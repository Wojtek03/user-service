FROM openjdk:21-jdk
MAINTAINER Wojtek03
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]