package edu.mum.cs.cs425.midten.midwestten.service.impl;

import edu.mum.cs.cs425.midten.midwestten.model.Athlete;
import edu.mum.cs.cs425.midten.midwestten.repository.AthleteRepository;
import edu.mum.cs.cs425.midten.midwestten.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AthleteServiceImpl implements AthleteService {

    private AthleteRepository athleteRepository;

    @Autowired
    public AthleteServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public List<Athlete> getAllAthleters() {
        return athleteRepository.findAll();
    }

    @Override
    public Athlete saveAthlete(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    @Override
    public List<Athlete> getEliteAthlete(Integer maxSal) {
        List<Athlete> eliteGuys = new ArrayList<>();
        for(Athlete at: getAllAthleters()){
            if(at.getSal() >= maxSal) eliteGuys.add(at);
        }
        System.out.println("eliteGuys = " + eliteGuys);
        return eliteGuys;
    }


}
