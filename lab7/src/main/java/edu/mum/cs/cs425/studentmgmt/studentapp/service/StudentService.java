package edu.mum.cs.cs425.studentmgmt.studentapp.service;

import edu.mum.cs.cs425.studentmgmt.studentapp.model.Student;

import java.util.List;

public interface StudentService {
    abstract List<Student> getAllStudents();
    abstract void saveStudent(Student student);
}
