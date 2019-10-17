package edu.mum.cs.cs425.demowebapps.goldendomemarket.service.impl;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Citizen;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.repository.CitizenRepository;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

import javax.validation.Valid;

@Service
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public Iterable<Citizen> getAllProduct() {
        return citizenRepository.findAll(Sort.by("lastName"));
    }

    @Override
    public Page<Citizen> getAllCitizenPaged(int page) {
        return citizenRepository.findAll(PageRequest.of(page, 5, Sort.by("lastName")));
    }

    @Override
    public Citizen registerNewCitizen(Citizen newCitizen) {
        return citizenRepository.save(newCitizen);
    }

    @Override
    public Citizen getCitizenById(Integer citizenId) {
        return citizenRepository.findById(citizenId).orElse(null);
    }

    @Override
    public Citizen saveCitizen(@Valid Citizen citizen) {
        return citizenRepository.save(citizen);
    }

	@Override
	public Double totalNetYearIncome() {
		List<Citizen> citizens = citizenRepository.findAll();
		Double sum =0.0;
		for(Citizen citizen: citizens)
			sum+=citizen.getYearlyIncome();
		return sum;
	}


}
