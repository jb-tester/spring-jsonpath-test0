package com.mytests.springboot.springjsonpathtest0.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytests.springboot.springjsonpathtest0.data.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
 
    @Autowired
    private DataUtil util;
 
    private static final ObjectMapper om = new ObjectMapper();
 
    public String getDetails() throws JsonProcessingException {
 
        return om.writeValueAsString(util.createCompany());
    }
}