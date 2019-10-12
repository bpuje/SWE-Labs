package edu.mum.cs.cs425.eregistrar.eregistrar.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {

    @Id@GeneratedValue
    private Long studentId;
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private double cgpa;
    private Boolean international;

    @OneToOne(cascade = CascadeType.ALL)
    private Transcript studentTranscript;

    @ManyToMany(mappedBy = "studentList", cascade = CascadeType.ALL)
    private List<Classroom> classroomList;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfEnrollment;

    public Student() {
    }

    public Student(Long studentId, String studentNumber, String firstName, String middleName, String lastName, double cgpa, Transcript studentTranscript, List<Classroom> classroomList, LocalDate dateOfEnrollment, Boolean international) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.studentTranscript = studentTranscript;
        this.classroomList = classroomList;
        this.dateOfEnrollment = dateOfEnrollment;
        this.international = international;
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa, Transcript studentTranscript, List<Classroom> classroomList, LocalDate dateOfEnrollment, Boolean international) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.studentTranscript = studentTranscript;
        this.classroomList = classroomList;
        this.dateOfEnrollment = dateOfEnrollment;
        this.international = international;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
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

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public Transcript getStudentTranscript() {
        return studentTranscript;
    }

    public void setStudentTranscript(Transcript studentTranscript) {
        this.studentTranscript = studentTranscript;
    }

    public List<Classroom> getClassroomList() {
        return classroomList;
    }

    public void setClassroomList(List<Classroom> classroomList) {
        this.classroomList = classroomList;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
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
                ", studentTranscript=" + studentTranscript +
                ", classroomList=" + classroomList +
                ", dateOfEnrollment=" + dateOfEnrollment +
                ", international=" + international +
                '}';
    }
}
