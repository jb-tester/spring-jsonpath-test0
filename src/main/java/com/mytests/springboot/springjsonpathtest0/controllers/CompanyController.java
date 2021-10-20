package com.mytests.springboot.springjsonpathtest0.controllers;

import java.util.List;

import com.mytests.springboot.springjsonpathtest0.data.Employee;
import com.mytests.springboot.springjsonpathtest0.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
 
@RestController
public class CompanyController {
 
    @Autowired
    private CompanyService companyService;
 
    private static final ObjectMapper om = new ObjectMapper();
 
    @GetMapping("/get-company-details")
    public ResponseEntity<String> getCompanyDetails() throws JsonProcessingException {
        return new ResponseEntity<>(companyService.getDetails(), HttpStatus.OK);
    }
 
    @GetMapping("/get-employees")
    public ResponseEntity<String> getEmployeeDetails() throws JsonProcessingException {
        String json = companyService.getDetails();
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        List<Employee> students = JsonPath.read(document, "$.teams[*].members");
        return new ResponseEntity<>(om.writeValueAsString(students), HttpStatus.OK);
    }
 
    @GetMapping("/get-employee-names")
    public ResponseEntity<String> getEmployeeNames() throws JsonProcessingException {
        String json = companyService.getDetails();
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        List<String> people = JsonPath.read(document, "$.teams[*].members[*].name");
        return new ResponseEntity<>(om.writeValueAsString(people), HttpStatus.OK);
    }
 
    @GetMapping("/employee-count")
    public ResponseEntity<Integer> getEmployeeCount() throws JsonProcessingException {
        String json = companyService.getDetails();
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        Integer count = JsonPath.read(document, "$.teams[*].members.length()");
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
 
    @GetMapping("/employee/{firstName}")
    public ResponseEntity<List<Employee>> getEmployeeCount(@PathVariable(value="firstName") String firstName) throws JsonProcessingException {
        String json = companyService.getDetails();
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        List<Employee> emp = JsonPath.read(document, "$..[?(@.name=='\n" + firstName + "')]");
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    @GetMapping("/girls")
    public ResponseEntity<List<Employee>> getAllGirls() throws JsonProcessingException {
        String json = companyService.getDetails();
        String jsonpath = "$..[?(@.gender=='female')].name";
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        List<Employee> emp = JsonPath.read(document, jsonpath);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }


}