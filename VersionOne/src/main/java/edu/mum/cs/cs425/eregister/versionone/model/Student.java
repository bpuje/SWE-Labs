package edu.mum.cs.cs425.eregister.versionone.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @NotBlank(message = "* Student Number is required")
    private String studentNumber; //e.g. 000-61-0001 (required)

    @NotBlank(message = "* First Name is required")
    private String firstName; // Anna (required)
    private String middleName;
    @NotBlank(message = "* Last Name is required")
    private String lastName; // optional

    @NotNull(message = "* CGPA is required")
    private Double cgpa; // cgpa: e.g. 3.78 (optional)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate; //enrollmentDate: e.g. 2019-5-12 (required)

    private Boolean international; // Hint: Implement/present this data in a drop-down list

    public Student() {
    }

    public Student(@NotBlank(message = "* Student Number is required") String studentNumber,
                   @NotBlank(message = "* First Name is required") String firstName, String middleName,
                   @NotBlank(message = "* Last Name is required") String lastName,
                   @NotBlank(message = "* CGPA is required") Double cgpa, LocalDate enrollmentDate, Boolean international) {
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

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
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
                ", cgpa=" + cgpa +
                ", enrollmentDate=" + enrollmentDate +
                ", international=" + international +
                '}';
    }
}
