package com.mikescherbakov.jobinterviewbase.repository;

import com.mikescherbakov.jobinterviewbase.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
