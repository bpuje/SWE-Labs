package mum.edu.swe.hcmcpatientsmgmtsystem.service;

import mum.edu.swe.hcmcpatientsmgmtsystem.domain.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService extends BaseService<Patient> {

    Optional<Patient> findByPatientNumber(String patientNumber);
    List<Patient> findByElderlyPatients(Integer age);

}
