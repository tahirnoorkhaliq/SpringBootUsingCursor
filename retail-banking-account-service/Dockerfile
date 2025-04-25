# Build stage for http-client-service
FROM maven:3.9.6-eclipse-temurin-21 AS http-client-build
WORKDIR /app
COPY retail-banking-http-client-service/pom.xml .
COPY retail-banking-http-client-service/src ./src
RUN mvn clean install -DskipTests

# Build stage for exception-handling
FROM maven:3.9.6-eclipse-temurin-21 AS exception-handling-build
WORKDIR /app
COPY retail-banking-exception-handling/pom.xml .
COPY retail-banking-exception-handling/src ./src
RUN mvn clean install -DskipTests

# Build stage for account service
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY --from=http-client-build /root/.m2 /root/.m2
COPY --from=exception-handling-build /root/.m2 /root/.m2
COPY retail-banking-account-service/pom.xml .
COPY retail-banking-account-service/src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/retail-banking-account-service-*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"] 