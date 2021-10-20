package com.mytests.springboot.springjsonpathtest0.data;

/**
 * *
 * <p>Created by irina on 20.01.2021.</p>
 * <p>Project: spring-jsonpath-test0</p>
 * *
 */
public class Location {
    String city;
    String country;

    public Location(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
