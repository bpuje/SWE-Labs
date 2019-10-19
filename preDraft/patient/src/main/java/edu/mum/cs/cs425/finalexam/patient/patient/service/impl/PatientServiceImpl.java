package edu.mum.cs.cs425.finalexam.patient.patient.service.impl;

import edu.mum.cs.cs425.finalexam.patient.patient.model.Patient;
import edu.mum.cs.cs425.finalexam.patient.patient.repository.PatientRepository;
import edu.mum.cs.cs425.finalexam.patient.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getElderlyPatients(Integer maxAge) {
        List<Patient> oldGuys = new ArrayList<>();
        for(Patient p: getAllPatient()){
            if(p.getAge() >= maxAge) oldGuys.add(p);
        }
        System.out.println("oldGuys = " + oldGuys);
        return oldGuys;
    }


}
