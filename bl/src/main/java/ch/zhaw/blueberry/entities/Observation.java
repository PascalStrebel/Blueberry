package ch.zhaw.blueberry.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int expectedAtMonths;
    private String category;
    private String text;

    @OneToMany(mappedBy="observation")
    private List<ChildObservation> childObservations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getExpectedAtMonths() {
        return expectedAtMonths;
    }

    public void setExpectedAtMonths(int expectedAtMonths) {
        this.expectedAtMonths = expectedAtMonths;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ChildObservation> getChildObservations() {
        return childObservations;
    }

    public void setChildObservations(List<ChildObservation> childObservations) {
        this.childObservations = childObservations;
    }
}
