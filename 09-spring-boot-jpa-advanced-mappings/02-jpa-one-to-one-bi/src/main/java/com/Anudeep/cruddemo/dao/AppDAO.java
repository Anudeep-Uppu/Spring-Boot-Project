package com.Anudeep.cruddemo.dao;

import com.Anudeep.cruddemo.entity.Instructor;
import com.Anudeep.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void removeInstructorById(int theId);

    void removeInstructorDetailById(int theId);
}
