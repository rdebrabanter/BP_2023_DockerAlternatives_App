FROM openjdk:17-jdk-alpine
ADD target/api-1.0-SNAPSHOT.jar api-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/api-1.0-SNAPSHOT.jar"]