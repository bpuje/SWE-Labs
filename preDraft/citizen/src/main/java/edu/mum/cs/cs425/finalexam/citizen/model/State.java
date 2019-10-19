package edu.mum.cs.cs425.finalexam.citizen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class State {
    @Id@GeneratedValue
    private Integer stateId;

    @NotBlank(message = "required")
    private String stateCode;

    @NotBlank(message = "required")
    private String stateName;

    @OneToMany(mappedBy = "state")
    private List<Citizen> citizens = new ArrayList<>();

    public State() {
    }

    public State(@NotBlank(message = "required") String stateCode, @NotBlank(message = "required") String stateName, List<Citizen> citizens) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.citizens = citizens;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }


}
