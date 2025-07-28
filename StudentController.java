package com.example.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentService service = new StudentService();

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) {
        service.addStudent(student);
        return "Student added.";
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        service.updateStudent(id, student);
        return "Student updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted.";
    }
}
