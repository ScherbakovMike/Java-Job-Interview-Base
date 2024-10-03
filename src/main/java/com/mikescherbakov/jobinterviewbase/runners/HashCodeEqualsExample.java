package com.mikescherbakov.jobinterviewbase.runners;

import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class HashCodeEqualsExample implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // hashCode is implemented, but equals is not implemented
        var audience = new HashSet<StudentWithHashCode>();
        var student1 = new StudentWithHashCode("John");
        var student2 = new StudentWithHashCode("Ivan");
        var student3 = new StudentWithHashCode("John");
        audience.add(student1);
        audience.add(student2);
        audience.add(student3);
        System.out.println("HashCode check:");
        System.out.printf("audience size: %d%n", audience.size());
        System.out.printf("New John exists: %b%n",
                audience.contains(new StudentWithHashCode("John"))
        );

        var audience2 = new HashSet<StudentWithEquals>();
        var student4 = new StudentWithEquals("John");
        var student5 = new StudentWithEquals("Ivan");
        var student6 = new StudentWithEquals("John");
        audience2.add(student4);
        audience2.add(student5);
        audience2.add(student6);
        System.out.println("Equals check:");
        System.out.printf("audience size: %d%n", audience2.size());
        System.out.printf("New John exists: %b%n",
                audience2.contains(new StudentWithEquals("John"))
        );
    }
}

class StudentWithHashCode {
    private final String name;
    public StudentWithHashCode(String name) {this.name = name;}
    public int hashCode() {
        return name.hashCode();
    }
}

class StudentWithEquals {
    private final String name;
    public StudentWithEquals(String name) {this.name = name;}
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentWithEquals that = (StudentWithEquals) o;
        return Objects.equals(that.name, name);
    }
}

