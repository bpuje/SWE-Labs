package edu.mum.cs.cs425.demowebapps.goldendomemarket.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Citizen {

    @Id@GeneratedValue
    private Long citizenId;

    @NotBlank(message = "required")
    private String socialSecurityNumber;
    @NotBlank(message = "required")
    private String firstName;
    private String middleName;
    @NotBlank(message = "required")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;


    private Double yearlyIncome;

    @ManyToOne
    @JoinColumn(name = "state_fk")
    private State state = new State();

    public Citizen() {
    }

    public Citizen(@NotBlank(message = "required") String socialSecurityNumber, @NotBlank(message = "required") String firstName, String middleName, @NotBlank(message = "required") String lastName, @NotBlank(message = "required") LocalDate dateOfBirth, @NotBlank(message = "required") Double yearlyIncome, State state) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.yearlyIncome = yearlyIncome;
        this.state = state;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(Double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "citizenId=" + citizenId +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", yearlyIncome=" + yearlyIncome +
                '}';
    }
}
