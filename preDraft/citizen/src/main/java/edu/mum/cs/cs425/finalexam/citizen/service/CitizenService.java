package edu.mum.cs.cs425.finalexam.citizen.service;

import edu.mum.cs.cs425.finalexam.citizen.model.Citizen;

import java.util.List;

public interface CitizenService {
    public abstract List<Citizen> getAllCitizen();
    public abstract Citizen saveCitizen(Citizen citizen);
    public abstract Double computeIncome();
}
