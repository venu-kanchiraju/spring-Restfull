package com.example.student;

import java.util.*;

public class StudentService {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Venu", "venu122@.com"));
        students.add(new Student(2, "Shiva", "shiva10@.com"));
    }

    public List<Student> getAll() {
        return students;
    }

    public Student getById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int id, Student updatedStudent) {
        Student existing = getById(id);
        if (existing != null) {
            existing.setName(updatedStudent.getName());
            existing.setEmail(updatedStudent.getEmail());
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}
