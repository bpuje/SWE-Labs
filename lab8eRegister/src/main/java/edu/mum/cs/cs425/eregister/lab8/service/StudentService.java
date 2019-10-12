package edu.mum.cs.cs425.eregister.lab8.service;

import edu.mum.cs.cs425.eregister.lab8.model.Student;

import java.util.List;

public interface StudentService {
    abstract List<Student> getAllStudents();
    abstract void saveStudent(Student student);
    abstract Student getStudentById(Long studentId);
    abstract void deleteStudentById(Long studentId);
}
