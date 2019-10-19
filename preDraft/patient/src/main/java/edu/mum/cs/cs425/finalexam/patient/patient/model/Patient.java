package edu.mum.cs.cs425.finalexam.patient.patient.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    private Long patientId; //(Primary Key)

    @NotNull(message = "Please provide patient number")
    private Long patientNumber; // (e.g. P1000001, EP1000002, EP1000003 etc.)


    private Boolean anOutPatient; // (values: “Yes” or “No”)

    @NotBlank(message = "Please provide fullname")
    private String fullNames; //(e.g. John H. Smith, Ann-Marie Washington, Diego A. Ortiz etc.)

    @NotBlank(message = "Please provide email address")
    private String emailAddress; // (e.g. jhsmith@globalmail.net, awashington@hcmc.org, etc.)

    @NotBlank(message = "Please provide phone number")
    private String contactPhoneNumber; // (e.g. (641) 001-0012, (641) 002-0034, etc.)

//    @NotBlank(message = "Please provide DOB")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth; // (e.g. 1959-5-21, 1949-12-3, etc.)




    public Patient() {
    }



    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(Long patientNumber) {
        this.patientNumber = patientNumber;
    }

    public Boolean getAnOutPatient() {
        return anOutPatient;
    }

    public void setAnOutPatient(Boolean anOutPatient) {
        this.anOutPatient = anOutPatient;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge(){
        Integer age = LocalDate.now().getYear() - this.dateOfBirth.getYear();
        System.out.println("age = " + age);
        return age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientNumber=" + patientNumber +
                ", isAnOutPatient=" + anOutPatient +
                ", fullNames='" + fullNames + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
