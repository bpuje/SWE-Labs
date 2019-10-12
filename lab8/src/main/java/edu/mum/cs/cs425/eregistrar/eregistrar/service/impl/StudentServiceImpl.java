package edu.mum.cs.cs425.eregistrar.eregistrar.service.impl;

import edu.mum.cs.cs425.eregistrar.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.eregistrar.repository.StudentRepo;

import edu.mum.cs.cs425.eregistrar.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return null;
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepo.deleteById(studentId);
    }
}
