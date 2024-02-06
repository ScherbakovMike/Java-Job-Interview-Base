package com.mikescherbakov.jobinterviewbase.runner;

import com.mikescherbakov.jobinterviewbase.model.Author;
import com.mikescherbakov.jobinterviewbase.model.Book;
import com.mikescherbakov.jobinterviewbase.model.Course;
import com.mikescherbakov.jobinterviewbase.repository.AuthorRepository;
import com.mikescherbakov.jobinterviewbase.repository.BookRepository;
import com.mikescherbakov.jobinterviewbase.repository.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    var author = new Author(0L, "Ivan Ivanov", new ArrayList<>(), new ArrayList<>());
    var course = new Course(0L, "Java Core", List.of(author));
    var book = new Book(0L, "Java Core", author);
    author.getCourses().add(course);
    author.getBooks().add(book);

    var savedAuthor = authorRepository.save(author);

    var courseId = savedAuthor.getCourses().get(0).getId();
    var bookId = savedAuthor.getBooks().get(0).getId();

    var savedCourse = courseRepository.findById(courseId);
    var savedBook = bookRepository.findById(bookId);

  }
}
