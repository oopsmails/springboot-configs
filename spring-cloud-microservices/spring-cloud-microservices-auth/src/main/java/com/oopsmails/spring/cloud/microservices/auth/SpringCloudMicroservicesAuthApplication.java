package com.oopsmails.spring.cloud.microservices.auth;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
//@EnableAuthorizationServer // Moved to OAuth2AuthorizationServerConfigJwt
@EnableEurekaClient
@RestController
@SessionAttributes("authorizationRequest")
public class SpringCloudMicroservicesAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMicroservicesAuthApplication.class, args);
    }

    @Profile("!cloud")
    @Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }

    @Configuration
    static class MvcConfig extends WebMvcConfigurerAdapter {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("login").setViewName("login");
//            registry.addViewController("/oauth/confirm_access").setViewName("authorize");
            registry.addViewController("/").setViewName("index");
        }
    }

    // @formatter:off
//    @Configuration // see WebSecurityConfig
//    static class LoginConfig extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .formLogin().loginPage("/login").permitAll()
//                    .and()
//                    .requestMatchers()
//                    .antMatchers("/", "/login", "/oauth/authorize", "/oauth/confirm_access")
//                    .and()
//                    .authorizeRequests()
//                    .anyRequest().authenticated();
//
//        }
//
//        @Override
//        @Bean
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }
//
//        @Autowired
//        public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
//            // @formatter:off
//            auth.inMemoryAuthentication()
//                    .withUser("user").password("password").roles("ADMIN").and()
//                    .withUser("john").password("123").roles("USER").and()
//                    .withUser("tom").password("111").roles("ADMIN").and()
//                    .withUser("user1").password("pass").roles("USER").and()
//                    .withUser("admin").password("nimda").roles("ADMIN");
//        }// @formatter:on
//    }
    // @formatter:on
}
