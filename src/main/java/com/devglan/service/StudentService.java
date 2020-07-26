package com.devglan.service;

import com.devglan.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getStudentList();

    public Student getStudent(int Id);

    public void save(Student theStudent);

    public void delete(int Id);
}
