package com.Anudeep.demo.rest;

import com.Anudeep.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;
    // define post construct here to load the data only once

    @PostConstruct
    public void loadData()
    {
        studentList = new ArrayList<>();

        studentList.add(new Student("Anudeep", "Uppu"));
        studentList.add(new Student("Kavya", "Uppu"));
        studentList.add(new Student("Harshita", "Uppu"));
    }
    // define endpoint for /students
    @GetMapping("/students")
    public List<Student> listOfStudents()
    {
        return studentList;
    }

    // define endpoint for /students/{studentId} - return student at that index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if(studentId >= studentList.size() || studentId < 0)
            throw new StudentNotFoundException("Student not found for id : " + studentId);
        return studentList.get(studentId);
    }
}
