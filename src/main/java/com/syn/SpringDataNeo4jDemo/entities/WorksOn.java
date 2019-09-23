package com.syn.SpringDataNeo4jDemo.entities;

import org.neo4j.ogm.annotation.*;

import java.time.LocalDate;

@RelationshipEntity(type = "WORKS_ON")
public class WorksOn {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private LocalDate started;
    @Property
    private LocalDate estimated;

    @StartNode
    private Student student;

    @EndNode
    private Projekt projekt;

    public WorksOn() {
        this(null, null);
    }

    public WorksOn(Student student, Projekt projekt) {
        this(null, null, student, projekt);
    }

    public WorksOn(LocalDate started, LocalDate estimated, Student student, Projekt projekt) {
        this.started = started;
        this.estimated = estimated;
        this.student = student;
        this.projekt = projekt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStarted() {
        return started;
    }

    public void setStarted(LocalDate started) {
        this.started = started;
    }

    public LocalDate getEstimated() {
        return estimated;
    }

    public void setEstimated(LocalDate estimated) {
        this.estimated = estimated;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }
}
