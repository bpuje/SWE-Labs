package edu.mum.cs.cs425.finalexam.patient.patient.repository;

import edu.mum.cs.cs425.finalexam.patient.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
