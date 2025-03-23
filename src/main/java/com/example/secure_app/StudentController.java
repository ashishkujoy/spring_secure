package com.example.secure_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @PostMapping("/students")
    public ResponseEntity<Object> createUser(@RequestBody Student student) {
        System.out.println(student.toString());
        try {
            this.studentRepository.save(student);
            return ResponseEntity.created(URI.create(String.format("/students/%s", student.getId()))).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
