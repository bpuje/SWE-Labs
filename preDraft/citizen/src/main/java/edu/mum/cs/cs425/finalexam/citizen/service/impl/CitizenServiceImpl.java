package edu.mum.cs.cs425.finalexam.citizen.service.impl;

import edu.mum.cs.cs425.finalexam.citizen.model.Citizen;
import edu.mum.cs.cs425.finalexam.citizen.repository.CitizenRepository;
import edu.mum.cs.cs425.finalexam.citizen.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImpl implements CitizenService {

    private CitizenRepository citizenRepository;

    @Autowired
    public CitizenServiceImpl(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @Override
    public List<Citizen> getAllCitizen() {
        return citizenRepository.findAll();
    }

    @Override
    public Citizen saveCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    @Override
    public Double computeIncome() {
        double totalBal =0.0;
        List<Citizen> citizenList = citizenRepository.findAll();
        for (Citizen cit : citizenList){
            totalBal += cit.getYearlyIncome();
        }
        return totalBal;
    }
}
