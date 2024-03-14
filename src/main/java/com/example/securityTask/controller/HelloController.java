package com.example.securityTask.controller;

import com.example.securityTask.security.PersonDetails;
import com.example.securityTask.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    private final AdminService service;

    @Autowired
    public HelloController(AdminService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/showInfo")
    @ResponseBody
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails principal = (PersonDetails) authentication.getPrincipal();
        System.out.println(principal.getPerson());
        return principal.getUsername();
    }

    @GetMapping("/admin")
    public String adminPage() {
        service.doAdminStuff();
        return "admin";
    }
}
