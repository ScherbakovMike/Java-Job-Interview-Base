package com.mikescherbakov.jobinterviewbase.javacore.mainprinciplesoop_4;

import com.mikescherbakov.jobinterviewbase.javacore.mainprinciplesoop_4.Examples.Animal;
import com.mikescherbakov.jobinterviewbase.javacore.mainprinciplesoop_4.Examples.Cat;
import com.mikescherbakov.jobinterviewbase.javacore.mainprinciplesoop_4.Examples.ClassWithEncapsulatedMembers;
import com.mikescherbakov.jobinterviewbase.javacore.mainprinciplesoop_4.Examples.Dog;
import com.mikescherbakov.jobinterviewbase.javacore.mainprinciplesoop_4.Examples.InheritedClass;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Runner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    System.out.println("4. What are the four main principles of Object-Oriented Programming (OOP)?");

    // Encapsulation
    var classInstance =  new ClassWithEncapsulatedMembers();
    classInstance.setFirstName("Mikhail");
    classInstance.setLastName("Shcherbakov");
    System.out.println(classInstance.getFirstName());
    System.out.println(classInstance.getLastName());
    classInstance.publicMethod();

    // Inheritance
    var inheritedClassInstance = new InheritedClass();
    inheritedClassInstance.setFirstName("Mikhail");
    inheritedClassInstance.setLastName("Shcherbakov");
    System.out.println(inheritedClassInstance.getFirstName());
    System.out.println(inheritedClassInstance.getLastName());

    // Polymorphism and abstraction
    Animal animal;
    animal = new Dog();
    animal.saySomething();
    animal = new Cat();
    animal.saySomething();
  }
}
