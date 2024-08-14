package com.mikescherbakov.jobinterviewbase.runner;

import com.fasterxml.jackson.databind.*;
import com.mikescherbakov.jobinterviewbase.model.*;
import com.mikescherbakov.jobinterviewbase.repository.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;


@Component
@Slf4j
@RequiredArgsConstructor
public class RunnerFlushModeCommit implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final CourseRepository courseRepository;
    private final BookRepository bookRepository;
    private final ObjectMapper mapper;

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        log.info("=== FlushModeType.COMMIT RUNNER:");

        entityManager.setFlushMode(FlushModeType.COMMIT);

        var author = new Author(10L, "Ivan Ivanov", new ArrayList<>(), new ArrayList<>());
        var course = new Course(10L, "Java Core", List.of(author));
        var book = new Book(10L, "Java Core", author);
        author.getCourses().add(course);
        author.getBooks().add(book);

        entityManager.merge(author);
        System.out.println(Utility.getAuthors().size());

        var authors = entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();

        System.out.println(Utility.getAuthors().size());
    }
}
