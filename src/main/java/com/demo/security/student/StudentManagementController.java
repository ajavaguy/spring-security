package com.demo.security.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jame"),
            new Student(2, "Jack"),
            new Student(3, "Janifer")
    );

    @GetMapping
    public List<Student> listStudents() {
        return STUDENTS;
    }

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student " + studentId + " does not found!"));
    }

    @PostMapping
    public void register(@RequestBody Student student) {
        System.out.println("Register a new student!");
    }

    @DeleteMapping(path = "{studentId}")
    public void delete(@PathVariable("studentId") Integer studentId) {
        System.out.println("Delete a student!");
    }

    @PutMapping(path = "{studentId}")
    public void update(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println("Update a student!");
    }
}
