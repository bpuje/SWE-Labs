package edu.mum.cs.cs425.eregistrar.eregistrar.repository;

import edu.mum.cs.cs425.eregistrar.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findStudentByStudentId(Long Id);
    List<Student> findAll();

    List<Student> findAllByStudentNumberContainingOrFirstNameContainingOrLastNameContainingOrdeOrderByStudentNumber(
            String studentNumber,
            String firstName,
            String lastName);

    List<Student> findAllByCgpaEquals(Double cgpa);
    List<Student> findAllByDateOfEnrollmentEquals(LocalDate dateOfEnrollment);
}
