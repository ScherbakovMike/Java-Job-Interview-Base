package com.mikescherbakov.jobinterviewbase.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class RunnerFlushModeAuto implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final CourseRepository courseRepository;
  private final BookRepository bookRepository;
  private final ObjectMapper mapper;

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    var author = new Author(0L, "Ivan Ivanov", new ArrayList<>(), new ArrayList<>());
    var course = new Course(0L, "Java Core", List.of(author));
    var book = new Book(0L, "Java Core", author);
    author.getCourses().add(course);
    author.getBooks().add(book);

    var savedAuthor = authorRepository.save(author);

    authorRepository.findById(savedAuthor.getId()).ifPresent(reposAuthor ->
    {
      System.out.println("Books count: " + (long) reposAuthor.getBooks().size());
      System.out.println("First book id: " + (long) reposAuthor.getBooks().get(0).getId());
      System.out.println("First course id: " + (long) reposAuthor.getCourses().get(0).getId());
      System.out.println(
          "Author Id in the first course: " + (long) reposAuthor.getCourses().get(0).getAuthors()
              .get(0).getId());
    });
  }
}
