package com.oopsmails.spring.cloud.microservicedocker.service.employeedashboard.controller;

import com.oopsmails.spring.cloud.microservicedocker.service.employeedashboard.domain.EmployeeInfo;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignEmployeeInfoController {
    @Autowired
    EmployeeSearchServiceProxy proxyService;

    @RequestMapping("/dashboard/feign/{myself}")
    public EmployeeInfo findme(@PathVariable Long myself) {
        return proxyService.findById(myself);
    }

    @RequestMapping("/dashboard/feign/peers")
    public Collection<EmployeeInfo> findPeers() {
        return proxyService.findAll();
    }
}
