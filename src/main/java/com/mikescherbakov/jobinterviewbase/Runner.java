package com.mikescherbakov.jobinterviewbase;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

  private final ObjectMapper mapper;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("21. How to transform an Array of objects to a Stream and vice versa?");

    @Getter
    class Car {

      private final Integer weight;
      private final String model;
      private final Integer year;
      private final String name;

      public Car(String name, String model, Integer year, Integer weight) {
        this.weight = weight;
        this.model = model;
        this.year = year;
        this.name = name;
      }
    }

    var list = List.of(
        new Car("Polo", "Volkswagen", 2020, 1500),
        new Car("Corolla", "Toyota", 2020, 1600),
        new Car("Camry", "Toyota", 2021, 1700),
        new Car("Dacia", "Renault", 2021, 1600)
    );

    // group by model and take a list
    var map1 = list.stream().collect(
        Collectors.groupingBy(Car::getModel)
    );
    System.out.println(mapper.writeValueAsString(map1));

    // group by model and take last value
    var map2 = list.stream()
        .collect(Collectors.toMap(Car::getModel, Car::getName, (name1, name2) -> name2));

    System.out.println(mapper.writeValueAsString(map2));

    // transform a map to the list
    var list1 = map1.values().stream().flatMap(Collection::stream).toList();
    System.out.println(mapper.writeValueAsString(list1));

    // transform a map to the list
    var list2 = map2.entrySet().stream()
        .map(entry -> new Car(entry.getValue(), entry.getKey(), null, null)).toList();
    System.out.println(mapper.writeValueAsString(list2));
  }
}
