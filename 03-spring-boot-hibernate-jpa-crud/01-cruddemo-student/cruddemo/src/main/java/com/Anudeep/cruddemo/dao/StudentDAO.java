package com.Anudeep.cruddemo.dao;

import com.Anudeep.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastname);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
