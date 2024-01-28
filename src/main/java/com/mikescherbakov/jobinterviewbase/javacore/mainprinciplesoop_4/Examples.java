package com.mikescherbakov.jobinterviewbase.javacore.mainprinciplesoop_4;

public class Examples {
  static class ClassWithEncapsulatedMembers {

    public String getFirstName() {
      System.out.println("Encapsulated logic to get a property.");
      return firstName;
    }

    public String getLastName() {
      System.out.println("Encapsulated logic to get a property.");
      return lastName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    private String firstName;
    private String lastName;
    private void encapsulatedMethod() {
      System.out.println("This is the internal implementation.");
    }

    public void publicMethod() {
      this.encapsulatedMethod();
    }
  }

  static class InheritedClass extends ClassWithEncapsulatedMembers {

    @Override
    public void setFirstName(String firstName) {
      System.out.println("The method 'setFirstName' has been changed in the child class.");
      super.setFirstName(firstName.toUpperCase());
    }
  }

  static interface Animal {
    void saySomething();
  }

  static class Dog implements Animal {

    @Override
    public void saySomething() {
      System.out.println("RRRRRRR");
    }
  }

  static class Cat implements Animal {

    @Override
    public void saySomething() {
      System.out.println("Mewoooo");
    }
  }

}
