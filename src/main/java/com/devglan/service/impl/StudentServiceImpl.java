package com.devglan.service.impl;

import com.devglan.dao.StudentRepository;
import com.devglan.dao.UserDao;
import com.devglan.model.Student;
import com.devglan.model.User;
import com.devglan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository theStudentRepository ) {

        studentRepository = theStudentRepository;
    }

    @Override
    public List<Student> getStudentList() {

        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(int Id) {
        Optional<Student> result = studentRepository.findById(Id);

        Student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find student id - " +Id);
        }

        return theStudent;
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);

    }

    @Override
    public void delete(int Id) {
        studentRepository.deleteById(Id);

    }





}
