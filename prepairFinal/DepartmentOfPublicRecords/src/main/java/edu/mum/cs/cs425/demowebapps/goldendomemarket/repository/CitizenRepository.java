package edu.mum.cs.cs425.demowebapps.goldendomemarket.repository;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

}
