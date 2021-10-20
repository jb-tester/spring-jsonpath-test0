package com.mytests.springboot.springjsonpathtest0.data;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 * <p>Created by irina on 20.01.2021.</p>
 * <p>Project: spring-jsonpath-test0</p>
 * *
 */
public class Employee {
    String name;
    String gender;
    String grade;
    String role;
    Boolean lead;
   
    Location location;
    public Employee(String name, String gender, String grade, Boolean lead, Location location, String role) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.lead = lead;
        this.location = location;
        this.role = role;
       
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Boolean getLead() {
        return lead;
    }

    public void setLead(Boolean lead) {
        this.lead = lead;
    }

    

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
