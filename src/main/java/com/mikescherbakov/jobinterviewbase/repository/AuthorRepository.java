package com.mikescherbakov.jobinterviewbase.repository;

import com.mikescherbakov.jobinterviewbase.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
