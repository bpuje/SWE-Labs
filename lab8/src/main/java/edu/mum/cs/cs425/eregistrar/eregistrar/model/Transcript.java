package edu.mum.cs.cs425.eregistrar.eregistrar.model;

import javax.persistence.*;

@Entity
public class Transcript {


    @Id@GeneratedValue
    private Long transcriptId;
    private String degreeTitle;

    @OneToOne(mappedBy = "studentTranscript", cascade = CascadeType.ALL)
    private Student student;

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Transcript() {
    }

    public Long getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Long transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }


    @Override
    public String toString() {
        return "Transcript{" +
                "transcriptId=" + transcriptId +
                ", degreeTitle='" + degreeTitle + '\'' +
                ", student=" + student +
                '}';
    }
}
