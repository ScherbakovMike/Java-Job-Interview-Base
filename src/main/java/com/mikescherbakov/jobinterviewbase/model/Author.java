package com.mikescherbakov.jobinterviewbase.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "authors", cascade = {CascadeType.DETACH, CascadeType.MERGE,
      CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Course> courses;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.EAGER)
  private List<Book> books;

  public Author(Long id, String name, List<Course> courses, List<Book> books) {
    this.id = id;
    this.name = name;
    this.courses = courses;
    this.books = books;
  }
}
