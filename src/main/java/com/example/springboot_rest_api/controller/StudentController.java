package com.example.springboot_rest_api.controller;


import com.example.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PutMapping("/students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

}
