package mum.edu.swe.hcmcpatientsmgmtsystem.domain;

import lombok.Getter;
import lombok.Setter;
import mum.edu.swe.hcmcpatientsmgmtsystem.domain.validators.UniquePatientNumber;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name="patients")
public class Patient {

    /*
    patientId:long, (Primary Key)
    patientNumber, (e.g. P1000001, EP1000002, EP1000003 etc.)
    isAnOutPatient: (values: “Yes” or “No”)
    fullNames, (e.g. John H. Smith, Ann-Marie Washington, Diego A. Ortiz etc.)
    emailAddress, (e.g. jhsmith@globalmail.net, awashington@hcmc.org, etc.)
    contactPhoneNumber, (e.g. (641) 001-0012, (641) 002-0034, etc.)
    dateOfBirth, (e.g. 1959-5-21, 1949-12-3, etc.)

    * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="patient_id")
    private Long patientId;

    @NotNull(message = "* Patient Number is required")
    @Column(name = "patient_number", nullable = false, unique = true)
    @UniquePatientNumber
    private String patientNumber;

    @NotEmpty
    @Column(name="is_an_out_patient")
    private String isAnOutPatient;

    @NotEmpty
    @Column(name="full_names")
    private String fullNames;

    @Email
    @Column(name="email_address")
    private String emailAddress;

    //123-456-7890
    //@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}")
    //(123) 456-7890
    @Pattern(regexp = "\\(\\d{3}\\) \\d{3}-\\d{4}", message = "(123) 456-7890")
    @Column(name="contact_phone_number")
    private String contactPhoneNumber;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="date_of_birth")
    //@PastOrPresent
    private String dateOfBirth;

}
