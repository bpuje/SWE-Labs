package edu.mum.cs.cs425.eregister.versionone.repository;

import edu.mum.cs.cs425.eregister.versionone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //List<Product> findAllByProductNumberContainingOr



//    List<Student> findAllByStudentNumberContainingOrFirstNameContainingOrLastNameContainingOrderByFirstName(
//            String studentId,
//            String firstName,
//            String lastName);
//    List<Student> findAllByCgpaEquals(Double cgpa);
//    List<Student> findAllByEnrollmentDateEquals(LocalDate enrollmentDate);

}
