package edu.mum.cs.cs425.finalexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.finalexam.model.Account;
import edu.mum.cs.cs425.finalexam.model.Product;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    // Relies on the default public abstract methods defined in the super interface, JpaRepository<T, ID>
    // We may override or add more methods here, if needed
}
