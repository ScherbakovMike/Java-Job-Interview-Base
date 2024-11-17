package com.mikescherbakov.jobinterviewbase.runners;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StreamDemoRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    @RequiredArgsConstructor
    @Getter
    class SomePersonObject {

      private final String name;
      private final int age;
    }

    var stringList = List.of("a", "b", "c", "ab", "ac", "a", "ca", "bb");
    var intList = List.of(10, 20, 30, 40, 50, 100, 1000, 10000);
    var objectList = List.of(
        new SomePersonObject("Alice", 20),
        new SomePersonObject("Bob", 30),
        new SomePersonObject("Charlie", 40)
    );

    // Create a String statistic map by count of "a" in each string
    var stringStatistic = stringList.stream()
        .collect(
            Collectors.groupingBy(Function.identity(),
                Collectors.summingInt((str) -> {
                  if (str.contains("a")) {
                    return 1;
                  } else {
                    return 0;
                  }
                }))
        );
    System.out.println(stringStatistic);

    // Create an Int statistics of values greater or equal than 100.
    // Reduce the map values afterward
    var reduceResult = intList.stream()
        .filter(number->number>=100)
        .collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.summingInt(number->number)
        ))
        .values().stream()
        .reduce(Integer::sum);
    System.out.println(reduceResult);

    // Create an age-based map:
    var ageMap = IntStream.of(10,20,30,40,50,60,70,80)
        .boxed()
        .collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.summingInt(
                age-> Math.toIntExact(objectList.stream()
                    .filter(person -> (person.age < age)
                        && (person.age >= age - 10)
                    ).count()))
        ));
    System.out.println(ageMap);
  }
}
