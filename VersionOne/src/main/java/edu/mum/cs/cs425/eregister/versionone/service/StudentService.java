package edu.mum.cs.cs425.eregister.versionone.service;

import edu.mum.cs.cs425.eregister.versionone.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Integer studentId);
    void deleteStudentById(Integer studentId);
    List<Student> searchStudents(String searchString);
}
