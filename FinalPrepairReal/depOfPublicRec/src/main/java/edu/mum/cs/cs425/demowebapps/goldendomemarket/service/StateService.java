package edu.mum.cs.cs425.demowebapps.goldendomemarket.service;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.State;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import java.util.List;

public interface StateService {
    public abstract List<State> getAllState();
    public abstract Page<State> getAllStatePaged(int page);
    public abstract State registerNewState(State newState);

    public abstract State getStateById(Integer stateId);
    public abstract State saveState(@Valid State state);

}
