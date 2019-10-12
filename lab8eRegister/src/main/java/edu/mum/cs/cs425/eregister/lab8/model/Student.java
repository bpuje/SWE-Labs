package edu.mum.cs.cs425.eregister.lab8.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Student {
    @Id
    @GeneratedValue
    private Integer studentId;

    @NotBlank(message = "Please provide number")
    private String studentNumber;

    @NotBlank(message = "Please provide first name")
    private String firstName;

    @NotBlank(message = "Please provide middle name")
    private String middleName;

    @NotBlank(message = "Please provide last name")
    private String lastName;

    private String cgpa;

    @NotBlank(message = "Please provide date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String enrollmentDate;

    private Boolean international;

    public Student() {
    }

    public Student(@NotBlank(message = "Please provide number") String studentNumber,
                   @NotBlank(message = "Please provide first name") String firstName,
                   @NotBlank(message = "Please provide middle name") String middleName,
                   @NotBlank(message = "Please provide last name") String lastName, String cgpa,
                   @NotBlank(message = "Please provide date") String enrollmentDate, Boolean international) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.international = international;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
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

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Boolean getInternational() {
        return international;
    }

    public void setInternational(Boolean international) {
        this.international = international;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa='" + cgpa + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                ", international=" + international +
                '}';
    }
}
