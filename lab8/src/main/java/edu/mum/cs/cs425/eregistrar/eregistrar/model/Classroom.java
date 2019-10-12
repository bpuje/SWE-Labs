package edu.mum.cs.cs425.eregistrar.eregistrar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Classroom {

    @Id@GeneratedValue
    private Long classroomId;
    private String buildingName;
    private String roomNumber;

    @ManyToMany
    private List<Student> studentList;


    public Classroom() {
    }

    public Classroom(String buildingName, String roomNumber, List<Student> studentList) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.studentList = studentList;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
