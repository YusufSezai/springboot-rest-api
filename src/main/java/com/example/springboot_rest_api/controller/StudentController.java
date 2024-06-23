package com.example.springboot_rest_api.controller;


import com.example.springboot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1,"George","Lucas");
        return student;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"George","Lucas"));
        students.add(new Student(2,"John","Doe"));
        students.add(new Student(3,"Arthur","Lee"));

        return students;
    }

    @GetMapping("/students/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId) {
        return new Student(studentId, "George","Lucas");
    }

    @GetMapping("/students/search")
    public Student studentRequestParam(@RequestParam int id) {
        return new Student(id,"George","Lucas");
    }

}
