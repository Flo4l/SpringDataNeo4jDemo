package com.syn.SpringDataNeo4jDemo.controller;

import com.syn.SpringDataNeo4jDemo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AppController {

    private AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/")
    public String read(Model model) {
        model.addAttribute("Studenten", appService.getStudenten());
        model.addAttribute("Projekte", appService.getProjeke());
        return "index.html";
    }

    @PostMapping("student/save")
    @ResponseBody
    public String saveStudent(String name, int alter) {
        appService.saveStudent(name, alter);
        return "";
    }

    @PostMapping("student/delete")
    @ResponseBody
    public String saveStudent(String name) {
        appService.deleteStudent(name);
        return "";
    }

    @PostMapping("student/assign")
    @ResponseBody
    public String saveProjekt(long studentID, long projektID, String start, String end) {
        appService.assignStudent(studentID, projektID, start, end);
        return "";
    }

    @PostMapping("projekt/save")
    @ResponseBody
    public String saveProjekt(String name, String beschreibung) {
        appService.saveProjekt(name, beschreibung);
        return "";
    }

    @PostMapping("projekt/delete")
    @ResponseBody
    public String deleteProjekt(String name) {
        appService.deleteProjekt(name);
        return "";
    }
}
