package com.bajajFinserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bajajFinserv.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}