package edu.mum.cs.cs425.eregister.versionone.repository;

import edu.mum.cs.cs425.eregister.versionone.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByStudentNumberContainingOrFirstNameContainingOrLastNameContainingOrderByFirstName(
            String studentId,
            String firstName,
            String lastName);
    List<Student> findAllByCgpaEquals(Double cgpa);
    List<Student> findAllByEnrollmentDateEquals(LocalDate enrollmentDate);
}
