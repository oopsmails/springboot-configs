package com.oopsmails.spring.cloud.microservicedocker.service.employeedashboard.controller;

import com.oopsmails.spring.cloud.microservicedocker.service.employeedashboard.domain.EmployeeInfo;
import java.util.Collection;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-employee-search")
@RibbonClient(name = "service-employee-search")
public interface EmployeeSearchServiceProxy {

    @RequestMapping("/employee/find/{id}")
    EmployeeInfo findById(@PathVariable(value = "id") Long id);

    @RequestMapping("/employee/findall")
    Collection<EmployeeInfo> findAll();

}
