package edu.mum.cs.cs425.midten.midwestten.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Customer")
public class Customer {


    @Id
    @GeneratedValue
    private Long customerId;

    @Column(name = "costomer_number")
    private Long customerNumber;

    @Column(name = "first_name")
    @NotBlank(message = "First Name should be entered")
    private String firstName;


    private String middleName;

    @Column(name = "customer_last_name")
    @NotBlank(message = "Last Name should be entered")
    private String lastName;

    @Column
    @NotBlank(message = "Email shoud be entered")
    private String emailAddress;

    @NotBlank(message = "Phone number should be entered")
    private String contactPhoneNumber;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Customer() {
    }


}
