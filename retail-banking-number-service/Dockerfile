# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY retail-banking-parent/pom.xml retail-banking-parent/
COPY retail-banking-soap-client/pom.xml retail-banking-soap-client/
COPY retail-banking-number-service/pom.xml retail-banking-number-service/
RUN mvn dependency:go-offline -B

COPY retail-banking-parent/src retail-banking-parent/src
COPY retail-banking-soap-client/src retail-banking-soap-client/src
COPY retail-banking-number-service/src retail-banking-number-service/src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/retail-banking-number-service/target/retail-banking-number-service-*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"] 