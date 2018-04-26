# springboot-apps

https://github.com/suzukij/spring-cloud-oauth2-zuul-eureka

-----------------------------

spring-cloud-oauth2-zuul-eureka




<groupId>com.oopsmails.spring.cloud.microservices</groupId>
<artifactId>spring-cloud-microservices</artifactId>

spring-cloud-microservices-eureka
com.oopsmails.spring.cloud.microservices.eureka
SpringCloudMicroservicesEurekaApplication


spring-cloud-microservices-auth
com.oopsmails.spring.cloud.microservices.auth
SpringCloudMicroservicesAuthApplication


spring-cloud-microservices-zuul
com.oopsmails.spring.cloud.microservices.zuul
SpringCloudMicroservicesZuulApplication


spring-cloud-microservices-resource
com.oopsmails.spring.cloud.microservices.resource
SpringCloudMicroservicesResourceApplication


spring-cloud-microservices-client
com.oopsmails.spring.cloud.microservices.client
SpringCloudMicroservicesClientApplication



----------------------------------

http://localhost:9999/client/
--> login.html

http://localhost:9999/client/logout????


index.html


--> get bearer token from log ....
RequestDumperFilter: header=authorization=bearer cd0b4a25-0151-426f-9159-a6f661a02d27

http://localhost:9999/api/messages
http://localhost:18081/api/messages

--> ok
http://localhost:8080/client/

--> 404
http://localhost:18081/resource/api/messages
http://localhost:18081/api/messages


http://localhost:9999/client/ user/password
http://localhost:8080/client/



-Dserver.port=18082


http://localhost:4203/ tom/111
http://localhost:4204/ john/123




================================================

Angular Frontend:

Read http://www.baeldung.com/rest-api-spring-oauth2-angularjs again.


spring-cloud-oauth-ui-implicit

The form login configuration isn’t necessary for the Password flow – only for the Implicit flow – so you may be able 
to skip it depending on what OAuth2 flow you’re using.

spring-security-oauth-ui-password:

--> password auth enabled by:

public class WebSecurityConfig extends WebSecurityConfigurerAdapter
??? .formLogin().permitAll()

::> using default spring security AuthenticationManager, Bearer token like: ef0bb9aa-8b5c-4dfe-93f3-b808e0e65039


--> Using JWT by adding:

::> Auth Server changes
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfigJwt extends AuthorizationServerConfigurerAdapter

mytest.jks

::> Resource Server changes

public.txt





--> get token
curl -X POST --user 'demo:demo' -d 'grant_type=password&username=user&password=password' http://localhost:9999/uaa/oauth/token

--> GET resource
curl -X "GET" -H "Authorization: Bearer ef0bb9aa-8b5c-4dfe-93f3-b808e0e65039" "http://localhost:9999/api/messages/"







