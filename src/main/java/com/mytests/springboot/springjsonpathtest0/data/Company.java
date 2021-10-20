package com.mytests.springboot.springjsonpathtest0.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * *
 * <p>Created by irina on 20.01.2021.</p>
 * <p>Project: spring-jsonpath-test0</p>
 * *
 */
public class Company {
    String name;
    List<Team> teams;

    

    public Company(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeams(Team... teams) {
        Collections.addAll(this.teams, teams);
    }
}
