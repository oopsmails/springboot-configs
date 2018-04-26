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

Read http://www.baeldung.com/rest-api-spring-oauth2-angularjs again.

@EnableAuthorizationServer
--> In order to persist the tokens, use a JdbcTokenStore, then sharing the SQL backed token store even though the 
Authorization and Resource servers are separate applications. The reason, of course, is that the Resource Server 
needs to be able to check the validity of the access tokens issued by the Authorization Server.

--> Instead of using a TokenStore in our Resource Server, we can use RemoteTokeServices:
e.g.

@Primary
@Bean
public RemoteTokenServices tokenService() {
    RemoteTokenServices tokenService = new RemoteTokenServices();
    tokenService.setCheckTokenEndpointUrl(
      "http://localhost:8080/spring-security-oauth-server/oauth/check_token");
    tokenService.setClientId("fooClientIdPassword");
    tokenService.setClientSecret("secret");
    return tokenService;
}

Note that:

This RemoteTokenService will use CheckTokenEndPoint on Authorization Server to validate AccessToken and obtain Authentication object from it.
The can be found at AuthorizationServerBaseURL +”/oauth/check_token“
The Authorization Server can use any TokenStore type [JdbcTokenStore, JwtTokenStore, …] – this won’t affect the RemoteTokenService or Resource server.

--> Resource server,

- @PreAuthorize("#oauth2.hasScope('read')") to guard controller endpoint.

- We also need to enable global method security and configure MethodSecurityExpressionHandler:
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ResourceServerConfig 
  extends GlobalMethodSecurityConfiguration {
 
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }
}



================================================

Angular Frontend:


-->  Front End – Implicit Grant

. Using the angular-oauth2-oidc directive to obtain the Access Token.
e.g,
import { OAuthService } from 'angular-oauth2-oidc';
import { Cookie } from 'ng2-cookies';

. Note how, after obtaining the Access Token, we’re using it via the Authorization header whenever we consume protected 
resources from within the Resource Server.



spring-cloud-oauth-ui-implicit

The form login configuration isn’t necessary for the Password flow – only for the Implicit flow – so you may be able 
to skip it depending on what OAuth2 flow you’re using.


--> Front end – Password Flow

Note that:

. To get an Access Token we send a POST to the “/oauth/token” endpoint
. We’re using the client credentials and Basic Auth to hit this endpoint
. We’re then sending the user credentials along with the client id and grant type parameters URL encoded
. After we obtain the Access Token – we store it in a cookie

The cookie storage is especially important here, because we’re only using the cookie for storage purposes and not to 
drive the authentication process directly. This helps protect against cross-site request forgery (CSRF) type of 
attacks and vulnerabilities.



spring-security-oauth-ui-password:

--> password auth enabled by:

public class WebSecurityConfig extends WebSecurityConfigurerAdapter
??? .formLogin().permitAll()

::> In order to use the “password” grant type we need to wire in and use the AuthenticationManager bean
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







