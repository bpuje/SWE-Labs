package edu.mum.cs.cs425.demowebapps.goldendomemarket.service.impl;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.State;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.repository.StateRepository;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<State> getAllState() {
        return stateRepository.findAll();
    }

    @Override
    public Page<State> getAllStatePaged(int page) {
        return stateRepository.findAll(PageRequest.of(page, 5, Sort.by("stateName")));
    }

    @Override
    public State registerNewState(State newState) {
        return stateRepository.save(newState);
    }

    @Override
    public State getStateById(Integer stateId) {
        return stateRepository.findById(stateId).orElse(null);
    }

    @Override
    public State saveState(@Valid State state) {
        return stateRepository.save(state);
    }


}
