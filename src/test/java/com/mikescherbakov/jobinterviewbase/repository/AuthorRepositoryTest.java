package com.mikescherbakov.jobinterviewbase.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mikescherbakov.jobinterviewbase.model.Author;
import com.mikescherbakov.jobinterviewbase.model.Book;
import com.mikescherbakov.jobinterviewbase.model.Course;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@DataJpaTest
@PropertySources({
    @PropertySource("classpath:application.properties"),
    @PropertySource("classpath:database.properties"),
    @PropertySource("classpath:flyway.properties")})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuthorRepositoryTest {

  @Autowired private AuthorRepository authorRepository;
  @Autowired CourseRepository courseRepository;
  @Autowired BookRepository bookRepository;

  @Test
  void saveTestWithoutCourses() {

    var author = new Author(1L, "Ivan Ivanov", List.of(), List.of());
    var savedAuthor = authorRepository.save(author);
    assertThat(savedAuthor.getId()).isNotNull();
  }

  @Test
  void saveTestWithCoursesAndBooks() {

    var author = new Author(0L, "Ivan Ivanov", new ArrayList<>(), new ArrayList<>());
    var course = new Course(0L, "Java Core", List.of(author));
    var book = new Book(0L, "Java Core", author);
    author.getCourses().add(course);
    author.getBooks().add(book);

    var savedAuthor = authorRepository.save(author);
    assertThat(savedAuthor.getId()).isNotNull();
    var courseId = savedAuthor.getCourses().get(0).getId();
    var bookId = savedAuthor.getBooks().get(0).getId();

    var savedCourse = courseRepository.findById(courseId);
    assertTrue(savedCourse.isPresent());
    assertThat(savedCourse.get().getId()).isNotNull();

    var savedBook = bookRepository.findById(bookId);
    assertTrue(savedBook.isPresent());
    assertThat(savedBook.get().getId()).isNotNull();
  }
}