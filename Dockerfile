# BUILD
FROM maven:3.8.6-eclipse-temurin-17 as build-step
WORKDIR /app/
ADD src/ /app/src/
ADD pom.xml /app/

RUN mvn --batch-mode install
VOLUME /app/data

# RUNTIME
FROM eclipse-temurin:17.0.4.1_1-jre
WORKDIR /app
COPY --from=build-step /app/target/invoice-service.jar /app/invoice-service.jar

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -jar /app/invoice-service.jar" ]

