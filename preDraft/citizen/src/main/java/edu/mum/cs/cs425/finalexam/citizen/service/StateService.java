package edu.mum.cs.cs425.finalexam.citizen.service;

import edu.mum.cs.cs425.finalexam.citizen.model.State;

import java.util.List;

public interface StateService {
    public abstract List<State> getAllState();
    public abstract State saveState(State state);
}
