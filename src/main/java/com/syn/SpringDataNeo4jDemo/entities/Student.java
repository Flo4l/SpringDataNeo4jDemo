package com.syn.SpringDataNeo4jDemo.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int alter;
    @Relationship
    private WorksOn worksOn;

    public Student() {
        this("", 0);
    }

    public Student(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public WorksOn getWorksOn() {
        return worksOn;
    }

    public void setWorksOn(WorksOn worksOn) {
        this.worksOn = worksOn;
    }
}
