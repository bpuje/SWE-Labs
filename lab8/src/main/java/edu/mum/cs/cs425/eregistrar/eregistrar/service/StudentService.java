package edu.mum.cs.cs425.eregistrar.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    abstract List<Student> getAllStudents();
    abstract Student saveStudent(Student student);
    abstract Student getStudentById(Long studentId);
    abstract void deleteStudentById(Long studentId);


    abstract List<Student> searchStudents(String searchStudent);

}
