# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY retail-banking-api-gateway/pom.xml .
COPY retail-banking-api-gateway/src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/retail-banking-api-gateway-*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"] 