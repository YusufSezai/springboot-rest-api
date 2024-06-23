package com.example.springboot_rest_api.controller;


import com.example.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

//    @GetMapping("/student")
//    public Student getStudent() {
//        Student student = new Student(1,"George","Lucas");
//        return student;
//    }

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1,"George","Lucas");
        return ResponseEntity.ok().header("custom-header", "Lolo").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"George","Lucas"));
        students.add(new Student(2,"John","Doe"));
        students.add(new Student(3,"Arthur","Lee"));

        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId) {
        Student student = new Student(studentId, "George","Lucas");
        return ResponseEntity.ok(student);
    }

    @GetMapping("/search")
    public ResponseEntity<Student> studentRequestParam(@RequestParam int id) {
        Student student = new Student(id,"George","Lucas");
        return ResponseEntity.ok(student);
    }

    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        return ResponseEntity.ok("Deleted successfully.");
    }

}
