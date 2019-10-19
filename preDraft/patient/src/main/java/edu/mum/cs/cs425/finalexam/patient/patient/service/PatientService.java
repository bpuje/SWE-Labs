package edu.mum.cs.cs425.finalexam.patient.patient.service;

import edu.mum.cs.cs425.finalexam.patient.patient.model.Patient;

import java.util.List;

public interface PatientService {
    public abstract List<Patient> getAllPatient();
    public abstract Patient savePatient(Patient patient);

    public abstract List<Patient> getElderlyPatients(Integer maxAge);

}
