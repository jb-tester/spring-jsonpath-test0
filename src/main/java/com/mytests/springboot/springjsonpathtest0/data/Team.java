package com.mytests.springboot.springjsonpathtest0.data;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 * <p>Created by irina on 20.01.2021.</p>
 * <p>Project: spring-jsonpath-test0</p>
 * *
 */
public class Team {
    String team_name;
    Employee lead;
    List<Employee> members;
    int size;

    public Team(String team_name) {
        this.team_name = team_name;
        this.members = new ArrayList<>();
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Employee getLead() {
        return lead;
    }

    public void setLead(Employee lead) {
        this.lead = lead;
    }

    public List<Employee> getMembers() {
        return members;
    }

    public void addMember(Employee member) {
        this.members.add(member);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
