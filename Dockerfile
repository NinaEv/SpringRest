FROM openjdk:8-jdk-alpine

EXPOSE 8080

COPY target/rest-0.0.1-SNAPSHOT.jar rest_app.jar

CMD ["java", "-jar", "rest_app.jar"]