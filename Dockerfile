FROM openjdk:17.0.2-jdk
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 9093
ENTRYPOINT ["java","-jar","/app/app.jar"]