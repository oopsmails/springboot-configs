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






