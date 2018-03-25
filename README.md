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

Eureka: http://localhost:8761/eureka/
Zuul: http://localhost:8762/routes
Request: http://localhost:8762/spring-cloud-eureka-client/greeting



====>


