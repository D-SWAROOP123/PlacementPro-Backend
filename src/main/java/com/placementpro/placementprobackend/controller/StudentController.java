
package com.placementpro.placementprobackend.controller;
import com.placementpro.placementprobackend.model.Student;
import com.placementpro.placementprobackend.model.StudentProfileResponse;
import com.placementpro.placementprobackend.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PostMapping("/login")
    public Student loginStudent(@RequestBody Student loginStudent) {
        return studentRepository.findByEmail(loginStudent.getEmail())
                .filter(student ->
                        student.getPassword().equals(loginStudent.getPassword()))
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password"));
    }

    @PutMapping("/profile")
    public Student updateProfile(@RequestBody Student profileData) {
        Student student = studentRepository
                .findByEmail(profileData.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        student.setName(profileData.getName());
        student.setStudentId(profileData.getStudentId());
        student.setCourse(profileData.getCourse());

        return studentRepository.save(student);
    }

    @GetMapping("/profile/{email}")
    public Student getStudentProfile(@PathVariable String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));
    }

    @GetMapping
    public List<StudentProfileResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentProfileResponse(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getPhone(),
                        student.getStudentId(),
                        student.getCourse()
                ))
                .toList();
    }
}
