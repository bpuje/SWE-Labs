package edu.mum.cs.cs425.finalexam.citizen.service.impl;

import edu.mum.cs.cs425.finalexam.citizen.model.State;
import edu.mum.cs.cs425.finalexam.citizen.repository.StateRepository;
import edu.mum.cs.cs425.finalexam.citizen.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    private StateRepository stateRepository;

    @Autowired
    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<State> getAllState() {
        return stateRepository.findAll();
    }

    @Override
    public State saveState(State state) {
        return stateRepository.save(state);
    }
}
