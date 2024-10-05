package com.mikescherbakov.jobinterviewbase.runner;

import com.mikescherbakov.jobinterviewbase.runner.SealedClassRunner.Cat.Leo;
import com.mikescherbakov.jobinterviewbase.runner.SealedClassRunner.Cat.Tiger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SealedClassRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    Cat tiger = new Tiger("tiger");
    Cat leo = new Leo("leo");
    System.out.println(tiger);
    System.out.println(leo);
  }

  static sealed class Cat permits Tiger, Leo {
    protected String kind;

    public Cat(String kind) {
      this.kind = kind;
    }

    @Override
    public String toString() {
      return "Cat{" +
          "kind='" + kind + '\'' +
          '}';
    }

    static final class Tiger extends Cat {
      public Tiger(String kind) {
        super(kind);
      }
    }

    static final class Leo extends Cat {
      public Leo(String kind) {
        super(kind);
      }
    }
  }
}
