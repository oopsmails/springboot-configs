package com.oopsmails.spring.cloud.microservicedocker.employeesearch.controller;

import com.oopsmails.spring.cloud.microservicedocker.employeesearch.domain.Employee;
import com.oopsmails.spring.cloud.microservicedocker.employeesearch.service.EmployeeSearchService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeSearchController {
    @Autowired
    EmployeeSearchService employeeSearchService;

    @RequestMapping("/employee/find/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeSearchService.findById(id);
    }

    @RequestMapping("/employee/findall")
    public Collection<Employee> findAll() {
        return employeeSearchService.findAll();
    }
}