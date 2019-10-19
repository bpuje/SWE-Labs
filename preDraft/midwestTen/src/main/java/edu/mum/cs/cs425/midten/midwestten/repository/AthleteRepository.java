package edu.mum.cs.cs425.midten.midwestten.repository;

import edu.mum.cs.cs425.midten.midwestten.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}
