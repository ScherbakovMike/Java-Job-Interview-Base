package com.mikescherbakov.jobinterviewbase.repository;

import com.mikescherbakov.jobinterviewbase.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
