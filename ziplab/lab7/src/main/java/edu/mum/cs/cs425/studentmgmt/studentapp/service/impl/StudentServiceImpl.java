package edu.mum.cs.cs425.studentmgmt.studentapp.service.impl;

import edu.mum.cs.cs425.studentmgmt.studentapp.model.Student;
import edu.mum.cs.cs425.studentmgmt.studentapp.repository.StudentRepo;
import edu.mum.cs.cs425.studentmgmt.studentapp.service.StudentService;
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
}
