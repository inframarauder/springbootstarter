package com.springbootcrud.springbootstarter.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if(studentExists){
            Optional<Student> student = studentRepository.findById(studentId);
            return  student.get();
        }else{
            throw new IllegalStateException("student with given id not found!");
        }
    }


    public void addStudent(Student student) {
       String email = student.getEmail();
       Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

       if(studentOptional.isPresent()){
           throw new IllegalStateException("email already taken!");
       }else{
           studentRepository.save(student);
       }
    }

    public void deleteStudent(long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if(studentExists){
            studentRepository.deleteById(studentId);
        }else{
            throw new IllegalStateException("student with given id not found!");
        }
    }


}
