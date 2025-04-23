# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY retail-banking-parent/pom.xml retail-banking-parent/
COPY retail-banking-api-gateway/pom.xml retail-banking-api-gateway/
RUN mvn dependency:go-offline -B

COPY retail-banking-parent/src retail-banking-parent/src
COPY retail-banking-api-gateway/src retail-banking-api-gateway/src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/retail-banking-api-gateway/target/retail-banking-api-gateway-*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"] 