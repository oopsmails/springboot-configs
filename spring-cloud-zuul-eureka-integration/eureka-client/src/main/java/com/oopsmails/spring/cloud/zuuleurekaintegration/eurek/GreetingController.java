package com.oopsmails.spring.cloud.zuuleurekaintegration.eurek;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {
    @RequestMapping("/greeting")
    String greeting();
}
