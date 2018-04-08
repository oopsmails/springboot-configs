# springboot-configs
Spring boot and cloud configurations, microservices

====> spring-boot-configuration-client, spring-boot-configuration-server

https://howtodoinjava.com/spring/spring-cloud/spring-cloud-config-server-git/ --> Thanks!

http://localhost:8080/msg

http://localhost:8888/config-server-client/development

http://localhost:8888/config-server-client/production

http://localhost:8080/refresh --> POST 

example local repo files, see springboot-configs\config-server-repo


====> spring-boot-microservice-eureka-naming-server,

http://www.springboottutorial.com/creating-microservices-with-spring-boot-part-1-getting-started --> Thanks, but too much Ads

--> need to be improved by adding Zuul ...

====> spring-cloud-zuul-eureka-integration
20180325: can only use 
<spring-boot.version>1.4.2.RELEASE</spring-boot.version>
<spring-cloud.version>Brixton.SR7</spring-cloud.version>

Zuul: pointing to euraka server by in application.properties
eureka.serviceurl.defaultzone=http://localhost:8761/eureka/

Euraka Client: application.yml
eureka:
  client:
    serviceUrl:
      defaultZone: ${EUREKA_URI:http://localhost:8761/eureka}

Eureka: http://localhost:8761 

Zuul: http://localhost:8762/routes

Request: http://localhost:8762/spring-cloud-eureka-client/greeting 

http://localhost:8762/foreign-exchange-service/currency-exchange/from/EUR/to/INR 


--> Thinkings:

http://localhost:8081/greeting is also working!

This should be solve by firewall.

https://stackoverflow.com/questions/41262716/dont-allow-direct-calls-to-microservices-only-allow-through-api-gateway 

Assuming that you have a firewall in place, you could restrict inbound traffic to server to the ports that your Zuul endpoints are exposed on and disallow anyone from accessing the microservices' ports directly.

If you want to avoid going the firewall route, you could force the endpoints to check for a specific HTTP header or something that is set by Zuul prior to forwarding a request, but that would be hacky and easy to circumvent. Based on my past experiences, the "right" way would be to do this via a firewall. Your app should be responsible for dealing with requests. Your firewall should be responsible for deciding who can hit specific endpoints.

====>

https://piotrminkowski.wordpress.com/2017/02/05/part-1-creating-microservice-using-spring-cloud-eureka-and-zuul/ 

Zuul –  gateway service that provides dynamic routing, monitoring, resiliency, security, and more

Ribbon – client side load balancer

Feign – declarative REST client

Eureka – service registration and discovery

Sleuth – distributed tracing via logs

Zipkin – distributed tracing system with request visualization

