package edu.mum.cs.cs425.midten.midwestten.service;

import edu.mum.cs.cs425.midten.midwestten.model.Athlete;

import java.util.List;

public interface AthleteService {
    public abstract List<Athlete> getAllAthleters();
    public abstract Athlete saveAthlete(Athlete athlete);
    public abstract List<Athlete> getEliteAthlete(Integer maxSal);
}
