package mum.edu.swe.hcmcpatientsmgmtsystem.service.impl;

import mum.edu.swe.hcmcpatientsmgmtsystem.domain.Patient;
import mum.edu.swe.hcmcpatientsmgmtsystem.repository.PatientRepository;
import mum.edu.swe.hcmcpatientsmgmtsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<Patient> findByPatientNumber(String patientNumber) {
        return patientRepository.findAllByPatientNumber(patientNumber);
    }

    @Override
    public List<Patient> findByElderlyPatients(Integer age) {
        return patientRepository.findByElderlyPatients(age);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public boolean delete(Long id) {
        patientRepository.deleteById(id);
        return true;
    }

    @Override
    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll(Sort.by("fullNames"));
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
