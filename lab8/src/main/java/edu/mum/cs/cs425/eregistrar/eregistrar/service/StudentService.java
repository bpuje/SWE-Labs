package edu.mum.cs.cs425.eregistrar.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    abstract List<Student> getAllStudents();
    abstract void saveStudent(Student student);
}
