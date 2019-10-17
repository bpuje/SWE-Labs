package edu.mum.cs.cs425.demowebapps.goldendomemarket.service;


import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Citizen;
import org.springframework.data.domain.Page;

import javax.validation.Valid;

public interface CitizenService {
    public abstract Iterable<Citizen> getAllProduct();
    public abstract Page<Citizen> getAllCitizenPaged(int page);
    public abstract Citizen registerNewCitizen(Citizen newCitizen);

    public abstract Citizen getCitizenById(Integer citizenId);
    public abstract Citizen saveCitizen(@Valid Citizen citizen);
    public abstract Double totalNetYearIncome();
}
