package edu.mum.cs.cs425.eregister.versionone.service;

import edu.mum.cs.cs425.eregister.versionone.model.Student;

import java.util.List;

public interface StudentService {
    public abstract List<Student> getAllStudents();
    public abstract Student saveStudent(Student student);
    public abstract Student getStudentById(Integer studentId);
    public abstract void deleteStudentById(Integer studentId);
    public abstract List<Student> searchStudents(String searchString);
}
