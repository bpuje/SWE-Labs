package mum.edu.swe.hcmcpatientsmgmtsystem.repository;

import mum.edu.swe.hcmcpatientsmgmtsystem.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT p.*, YEAR(CURDATE()) - YEAR(p.date_of_birth) AS age \n" +
            "FROM Patients p\n" +
            "where YEAR(CURDATE()) - YEAR(date_of_birth) >= :age \n" +
            "order by date_of_birth desc ", nativeQuery = true)
    List<Patient> findByElderlyPatients(Integer age);

    Optional<Patient> findAllByPatientNumber(String patientNumber);

}
