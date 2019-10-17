package edu.mum.cs.cs425.demowebapps.goldendomemarket.repository;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}
