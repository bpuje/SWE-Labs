package edu.mum.cs.cs425.studentmgmt.studentapp.repository;

import edu.mum.cs.cs425.studentmgmt.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findStudentByStudentId(Long Id);
    List<Student> findAll();
}
