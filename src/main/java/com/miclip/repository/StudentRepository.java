package com.miclip.repository;

import com.miclip.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository extends InMemoryRepository<Student> {
}
