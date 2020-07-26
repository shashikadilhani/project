package com.devglan.controller;

import com.devglan.model.Student;
import com.devglan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService theStudentService) {

        studentService = theStudentService;

    }

    @GetMapping("/list")
    public List<Student> findAll(){
        return studentService.getStudentList();
    }

    @GetMapping("/list/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        Student theEmployee = studentService.getStudent(studentId);

        if (theEmployee == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        return theEmployee;
    }

    @PutMapping("/save")
    public Student updateStudent(@RequestBody Student theStudent) {

        studentService.save(theStudent);

        return theStudent;
    }


    @DeleteMapping("/delete/{studentId}")
    public String deleteEmployee(@PathVariable int studentId) {

        Student tempStudent = studentService.getStudent(studentId);

        // throw exception if null

        if (tempStudent == null) {
            throw new RuntimeException("Employee id not found - " + studentId);
        }

        studentService.delete(studentId);

        return "Deleted student id - " + studentId;
    }
}
