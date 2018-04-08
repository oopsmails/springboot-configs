
====> alpine-java:base

see http://www.baeldung.com/dockerizing-spring-boot-application

--> need 
REQUIREMENTS: In order to run the tutorial successfully, you have to download the Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files 
from Oracle. Simply extract the downloaded archive into a local folder named 'files.

--> then
docker build --file=Dockerfile-alpine-java.txt --tag=alpine-java:base --rm=true .

docker volume create --name=microservice-docker-config-repo

winpty docker exec -it bf9507093b97 bash






