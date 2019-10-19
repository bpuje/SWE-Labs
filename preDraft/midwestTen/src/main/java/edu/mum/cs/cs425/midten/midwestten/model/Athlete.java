package edu.mum.cs.cs425.midten.midwestten.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
public class Athlete {

    @Id @GeneratedValue
    private Long athleteId;


    @NotBlank(message = "Please provide ssn")
    @Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "* Social security number (123) 456-7890.")
    private String ssn; // This is 123-45-6789

//    @NotBlank(message = "Please provide fullName")
    private String fullName;

    @NotEmpty(message = "* Contact number is required.")
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfRegistration;

    @NotNull(message = "Please provide total number of medals")
    private Integer totalNumberOfMedalsWon;

    @NotNull(message = "Please provide monthly salary")
    private Double monthlySalary;

    private String emailAddress;


    public Athlete() {
    }

    public Athlete(@NotBlank(message = "Please provide ssn") @Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "* Social security number (123) 456-7890.") String ssn, @NotBlank(message = "Please provide fullName") String fullName, @NotEmpty(message = "* Contact number is required.") String phoneNumber, LocalDate dateOfBirth, LocalDate dateOfRegistration, @NotNull(message = "Please provide total number of medals") Integer totalNumberOfMedalsWon, @NotNull(message = "Please provide monthly salary") Double monthlySalary, String emailAddress) {
        this.ssn = ssn;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
        this.totalNumberOfMedalsWon = totalNumberOfMedalsWon;
        this.monthlySalary = monthlySalary;
        this.emailAddress = emailAddress;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Integer getTotalNumberOfMedalsWon() {
        return totalNumberOfMedalsWon;
    }

    public void setTotalNumberOfMedalsWon(Integer totalNumberOfMedalsWon) {
        this.totalNumberOfMedalsWon = totalNumberOfMedalsWon;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Double getSal(){
        //Integer salary = LocalDate.now().getYear() - this.dateOfBirth.getYear();
        double salary = monthlySalary + monthlySalary * 1.5;
        System.out.println("age = " + salary);
        return salary;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteId=" + athleteId +
                ", ssn='" + ssn + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfRegistration=" + dateOfRegistration +
                ", totalNumberOfMedalsWon=" + totalNumberOfMedalsWon +
                ", monthlySalary=" + monthlySalary +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
