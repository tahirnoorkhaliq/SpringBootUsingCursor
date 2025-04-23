# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY retail-banking-parent/pom.xml retail-banking-parent/
COPY retail-banking-http-client-service/pom.xml retail-banking-http-client-service/
RUN mvn dependency:go-offline -B

COPY retail-banking-parent/src retail-banking-parent/src
COPY retail-banking-http-client-service/src retail-banking-http-client-service/src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/retail-banking-http-client-service/target/retail-banking-http-client-service-*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"] 