package ch.zhaw.blueberry.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Child extends Person {
    @OneToMany(mappedBy="child")
    private List<ChildObservation> childObservations;

}
