package com.mytests.springboot.springjsonpathtest0.data;

import org.springframework.stereotype.Component;

/**
 * *
 * <p>Created by irina on 20.01.2021.</p>
 * <p>Project: spring-jsonpath-test0</p>
 * *
 */
@Component
public class DataUtil {
    
    public Company createCompany(){
        Location spb = new Location("Sankt-Petersburg","Russia");
        Location msk = new Location("Moscow","Russia");
        Location lon = new Location("London","UK");
        Location man = new Location("Manchester","UK");
        Team frontend = new Team("frontend");
        Team server = new Team("server");
        Team qa = new Team("qa");
        Team marketing = new Team("marketing");
        Employee qa1 = new Employee("vasya ivanov", "male", "senior", false, msk, "qa");
       
        qa.addMember(qa1);
        frontend.addMember(qa1);
        Employee qa2 = new Employee("valya petrova", "female", "junior", false, spb, "qa");
        
        qa.addMember(qa2);
        frontend.addMember(qa2);
        Employee qa3 = new Employee("masha ivanova", "female", "senior", true, msk, "qa");
        
        qa.addMember(qa3);
        frontend.addMember(qa3);
        Employee qa4 = new Employee("vasya sidorov", "male", "junior", false, spb, "qa");
       
        qa.addMember(qa4);
        server.addMember(qa4);
        Employee qa5 = new Employee("ivan semenov", "male", "senior", false, spb, "qa");
        
        qa.addMember(qa5);
        server.addMember(qa5);
        Employee qa6 = new Employee("vika smirnova", "female", "junior", false, lon, "qa");
       
        qa.addMember(qa6);
        server.addMember(qa6);
        Employee qa7 = new Employee("anya sokolova", "female", "senior", true, spb, "qa");
        
        qa.addMember(qa7);
        server.addMember(qa7);
        Employee qa8 = new Employee("vera dmitrieva", "female", "senior", true, spb, "qa");
       
        qa.addMember(qa8);
        qa.setLead(qa8);
        Employee dev1 = new Employee("vera andreeva", "female", "senior", false, man, "dev");
       
        frontend.addMember(dev1);
        Employee dev2 = new Employee("masha sergeeva", "female", "junior", false, msk, "dev");
        
        frontend.addMember(dev2);
        Employee dev3 = new Employee("misha petrov", "male", "senior", true, msk, "dev");
       
        frontend.addMember(dev3);
        frontend.setLead(dev3);
        Employee dev4 = new Employee("misha sergeev", "male", "junior", false, man, "dev");
       
        frontend.addMember(dev4);
        Employee dev5 = new Employee("sergey krylov", "male", "senior", false, spb, "dev");
       
        server.addMember(dev5);
        Employee dev6 = new Employee("max andreev", "male", "senior", true, spb, "dev");
        server.addMember(dev6);
        server.setLead(dev6);
        Employee dev7 = new Employee("max novikov", "male", "junior", false, lon, "dev");
        server.addMember(dev7);
        
        Company company = new Company("superCompany");
        company.addTeams(frontend, server, qa, marketing);
        return company;
    }
}
