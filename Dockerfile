FROM openjdk:8-jdk-alpine

ADD target/*.jar crud-spring.jar

ENTRYPOINT [ "sh", "-c", "java -jar crud-spring.jar" ]