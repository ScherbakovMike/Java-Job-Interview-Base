package com.mikescherbakov.jobinterviewbase.runners;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class NIOvsClassicFileAPIDemo implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    var currentTime = System.currentTimeMillis();
    var file = generateBigFile();
    System.out.printf("File generation, ms: %d%n", System.currentTimeMillis() - currentTime);
    currentTime = System.currentTimeMillis();
    readFileIO(file);
    System.out.printf("Spent ot the blocking read, ms: %d%n",
        System.currentTimeMillis() - currentTime);
    currentTime = System.currentTimeMillis();
    readFileNIO(file);
    System.out.printf("Spent ot the NIO read, ms: %d%n", System.currentTimeMillis() - currentTime);

    Files.delete(file);
  }

  private void readFileIO(Path file) throws IOException {
    var inputStream = new FileInputStream(file.toFile());
    var buffer = new byte[(int) Files.size(file)];
    var readBytes = inputStream.read(buffer);
    while (readBytes != -1) {
      readBytes = inputStream.read(buffer);
    }
    inputStream.close();
  }

  private void readFileNIO(Path file) throws IOException {
    try (var channel = new RandomAccessFile(file.toFile(), "r").getChannel()) {
      var buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
      while (buffer.hasRemaining()) {
        buffer.get();
      }
    }
  }

  private Path generateBigFile() throws IOException {
    var path = Path.of(String.format("%s.txt", UUID.randomUUID()));
    var file = new RandomAccessFile(path.toFile(), "rw");
    var channel = file.getChannel();
    var buffer = ByteBuffer.allocate(1024);
    var rows = 10;
    while (rows > 0) {
      var string = UUID.randomUUID() + "\n";
      buffer.put(string.getBytes());
      buffer.flip();
      channel.write(buffer);
      buffer.clear();
      rows--;
    }
    file.close();
    return path;
  }
}
