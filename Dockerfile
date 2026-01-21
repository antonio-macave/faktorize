FROM eclipse-temurin:25
WORKDIR /app
COPY target/faktorize-0.0.1-SNAPSHOT.jar /app/faktorize.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "faktorize.jar"]