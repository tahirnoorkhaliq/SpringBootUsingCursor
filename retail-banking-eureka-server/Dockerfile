# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY retail-banking-parent/pom.xml retail-banking-parent/
COPY retail-banking-eureka-server/pom.xml retail-banking-eureka-server/
RUN mvn dependency:go-offline -B

COPY retail-banking-parent/src retail-banking-parent/src
COPY retail-banking-eureka-server/src retail-banking-eureka-server/src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/retail-banking-eureka-server/target/retail-banking-eureka-server-*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"] 