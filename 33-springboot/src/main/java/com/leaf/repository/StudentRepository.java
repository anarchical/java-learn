package com.leaf.repository;

import com.leaf.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 */
@Repository
public interface StudentRepository {
    Student findById(int id);

    List<Student> findAll();

    void save(Student student);

    void deleteById(int id);

    void update(Student student);
}
