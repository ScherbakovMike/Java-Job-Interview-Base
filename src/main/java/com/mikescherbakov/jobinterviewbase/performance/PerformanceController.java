package com.mikescherbakov.jobinterviewbase.performance;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerformanceController {

  private static final int ITERATIONS = 100000;
  private static final int MEASURES = 5;
  private static final SecureRandom RANDOM = new SecureRandom();

  private final Timer timerArrayListSearch;
  private final Timer timerArrayListAdd;
  private final Timer timerArrayListRemoveByIndex;
  private final Timer timerLinkedListSearch;
  private final Timer timerLinkedListAdd;
  private final Timer timerLinkedListRemoveByIndex;

  public PerformanceController(MeterRegistry registry) {
    timerArrayListSearch = Timer.builder("arraylist.search")
        .description("Search in ArrayList")
        .tags("region", "us-east")
        .register(registry);
    timerArrayListAdd = Timer.builder("arraylist.add")
        .description("Add to ArrayList")
        .tags("region", "us-east")
        .register(registry);
    timerArrayListRemoveByIndex = Timer.builder("arraylist.remove")
        .description("Remove from ArrayList")
        .tags("region", "us-east")
        .register(registry);

    timerLinkedListSearch = Timer.builder("linkedlist.search")
        .description("Search in LinkedList")
        .tags("region", "us-east")
        .register(registry);
    timerLinkedListAdd = Timer.builder("linkedlist.add")
        .description("Add to LinkedList")
        .tags("region", "us-east")
        .register(registry);
    timerLinkedListRemoveByIndex = Timer.builder("linkedlist.remove")
        .description("Remove from LinkedList")
        .tags("region", "us-east")
        .register(registry);
  }

  // Access results by link:
  // http://localhost:8080/actuator/metrics/arraylist.*
  @GetMapping("/time-array-list")
  public String timeArrayList() {

    Runnable addToArrayList = () -> {
      var list = new ArrayList<Integer>();
      for (var i = 0; i < ITERATIONS; i++) {
        list.add(RANDOM.nextInt());
      }
    };

    Runnable searchInArrayList = () -> {
      var list = new ArrayList<Integer>();
      for (var i = 0; i < ITERATIONS; i++) {
        list.add(RANDOM.nextInt());
      }
      for (var i = 0; i < ITERATIONS; i++) {
        var elem = list.get(RANDOM.nextInt(ITERATIONS));
      }
    };

    Runnable removeFromArrayList = () -> {
      var list = new ArrayList<Integer>();
      for (var i = 0; i < ITERATIONS; i++) {
        list.add(RANDOM.nextInt());
      }
      for (var i = 0; i < ITERATIONS; i++) {
        var elem = list.remove(list.size() / 2);
      }
    };

    for (var i = 0; i < MEASURES; i++) {
      timerArrayListAdd.record(addToArrayList);
    }

    for (var i = 0; i < MEASURES; i++) {
      timerArrayListSearch.record(searchInArrayList);
    }

    for (var i = 0; i < MEASURES; i++) {
      timerArrayListRemoveByIndex.record(removeFromArrayList);
    }

    return "Action has been recorded.";
  }

  // Access results by link:
  // http://localhost:8080/actuator/metrics/arraylist.*
  @GetMapping("/time-linked-list")
  public String timeLinkedList() {

    Runnable addToLinkedList = () -> {
      var list = new LinkedList<Integer>();
      for (var i = 0; i < ITERATIONS; i++) {
        list.add(RANDOM.nextInt());
      }
    };

    Runnable searchInLinkedList = () -> {
      var list = new LinkedList<Integer>();
      for (var i = 0; i < ITERATIONS; i++) {
        list.add(RANDOM.nextInt());
      }
      for (var i = 0; i < ITERATIONS; i++) {
        var elem = list.get(RANDOM.nextInt(ITERATIONS));
      }
    };

    Runnable removeFromLinkedList = () -> {
      var list = new LinkedList<Integer>();
      for (var i = 0; i < ITERATIONS; i++) {
        list.add(RANDOM.nextInt());
      }
      for (var i = 0; i < ITERATIONS; i++) {
        var elem = list.remove(list.size() / 2);
      }
    };

    for (var i = 0; i < MEASURES; i++) {
      timerLinkedListAdd.record(addToLinkedList);
    }

    for (var i = 0; i < MEASURES; i++) {
      timerLinkedListSearch.record(searchInLinkedList);
    }

    for (var i = 0; i < MEASURES; i++) {
      timerLinkedListRemoveByIndex.record(removeFromLinkedList);
    }

    return "Action has been recorded.";
  }

}
