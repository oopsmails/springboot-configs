package com.oopsmails.spring.cloud.microservices.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("ADMIN").and()
                .withUser("john").password("123").roles("USER").and()
                .withUser("tom").password("111").roles("ADMIN").and()
                .withUser("user1").password("pass").roles("USER").and()
                .withUser("admin").password("nimda").roles("ADMIN");
    }// @formatter:on

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off

        http
                .formLogin().loginPage("/login").permitAll()
                .and()
                .requestMatchers()
                .antMatchers("/", "/login", "/oauth/authorize", "/oauth/confirm_access")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();

//		http.authorizeRequests()
//			.antMatchers("/login").permitAll()
//			.antMatchers("/oauth/token/revokeById/**").permitAll()
//			.antMatchers("/tokens/**").permitAll()
//			.antMatchers("/", "/login", "/oauth/authorize", "/oauth/confirm_access").permitAll() // added
//			.anyRequest().authenticated()
//
//			.and()
//			.formLogin().loginPage("/login").permitAll()
//
//			.and()
//			.csrf().disable();


        // @formatter:off
//		http.formLogin().loginPage("/login").permitAll()
//			.and()
//			.requestMatchers()
//			.antMatchers("/", "/login", "/oauth/authorize", "/oauth/confirm_access")
//			.and()
//			.authorizeRequests()
//			.anyRequest().authenticated();
        // @formatter:on
    }

}

