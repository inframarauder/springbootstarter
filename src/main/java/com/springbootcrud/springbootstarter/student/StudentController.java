package com.springbootcrud.springbootstarter.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping(path = "{studentId}")
    public Student getStudentById(@PathVariable("studentId") long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") long studentId,
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String email
    ){
        studentService.updateStudent(studentId,name,email);
    }


    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") long studentId){
        studentService.deleteStudent(studentId);
    }
}
