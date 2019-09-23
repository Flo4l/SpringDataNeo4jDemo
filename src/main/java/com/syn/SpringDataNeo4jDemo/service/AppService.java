package com.syn.SpringDataNeo4jDemo.service;

import com.syn.SpringDataNeo4jDemo.entities.Projekt;
import com.syn.SpringDataNeo4jDemo.entities.Student;
import com.syn.SpringDataNeo4jDemo.entities.WorksOn;
import com.syn.SpringDataNeo4jDemo.repositories.ProjektRepo;
import com.syn.SpringDataNeo4jDemo.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppService {

    private StudentRepo studentRepo;
    private ProjektRepo projektRepo;

    @Autowired
    public AppService(StudentRepo studentRepo, ProjektRepo projektRepo) {
        this.studentRepo = studentRepo;
        this.projektRepo = projektRepo;
    }

    public void saveStudent(String name, int alter) {
        Student student = new Student(name, alter);
        studentRepo.save(student);
    }

    public void saveProjekt(String name, String beschreibung) {
        Projekt projekt = new Projekt(name, beschreibung);
        projektRepo.save(projekt);
    }

    public void assignStudent(long studentID, long projektID, String start, String end) {
        Student student = studentRepo.findById(studentID).get();
        Projekt projekt = null;
        WorksOn worksOn = null;
        if (projektID != -1) {
            projekt = projektRepo.findById(projektID).get();
            worksOn = new WorksOn(LocalDate.parse(start), LocalDate.parse(end), student, projekt);
        }
        student.setWorksOn(worksOn);
        studentRepo.save(student);
    }

    public List<Student> getStudenten() {
        return (List<Student>) studentRepo.findAll();
    }

    public List<Projekt> getProjeke() {
        return (List<Projekt>) projektRepo.findAll();
    }

    public void deleteStudent(String name) {
        studentRepo.deleteAllByName(name);
    }

    public void deleteProjekt(String name) {
        projektRepo.deleteAllByName(name);
    }
}
