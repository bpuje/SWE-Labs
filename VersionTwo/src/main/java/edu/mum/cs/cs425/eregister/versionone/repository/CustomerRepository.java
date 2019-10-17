package edu.mum.cs.cs425.eregister.versionone.repository;

import edu.mum.cs.cs425.eregister.versionone.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByCustomerIdContainingOrNameContainingOrDateOfBirthContainingOrderByName(
            Long customerId,
            String name,
            LocalDate dateOfBirth
    );


    List<Customer> findAllByCustomerIdEquals(Long customerId);
    List<Customer> findAllByDateOfBirthEquals(LocalDate dateOfBirth);

}
