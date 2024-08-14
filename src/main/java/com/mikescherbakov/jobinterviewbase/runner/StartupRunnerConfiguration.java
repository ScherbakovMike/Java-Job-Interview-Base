package com.mikescherbakov.jobinterviewbase.runner;

import com.mikescherbakov.jobinterviewbase.repository.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupRunnerConfiguration implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final CourseRepository courseRepository;
  private final BookRepository bookRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {
//    var author = new Author(0L, "Ivan Ivanov", new ArrayList<>(), new ArrayList<>());
//    var course = new Course(0L, "Java Core", List.of(author));
//    var book = new Book(0L, "Java Core", author);
//    author.getCourses().add(course);
//    author.getBooks().add(book);
//
//    var savedAuthor = authorRepository.save(author);
//
//    var courseId = savedAuthor.getCourses().get(0).getId();
//    var bookId = savedAuthor.getBooks().get(0).getId();
//
//    var savedCourse = courseRepository.findById(courseId);
//    var savedBook = bookRepository.findById(bookId);

  }
}
