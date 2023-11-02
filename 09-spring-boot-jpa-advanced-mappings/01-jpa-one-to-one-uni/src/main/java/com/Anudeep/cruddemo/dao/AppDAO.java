package com.Anudeep.cruddemo.dao;

import com.Anudeep.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void removeInstructorById(int theId);
}
