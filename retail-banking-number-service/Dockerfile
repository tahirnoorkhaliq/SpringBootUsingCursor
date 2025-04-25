# Build stage for SOAP client
FROM maven:3.9.6-eclipse-temurin-21 AS soap-client-build
WORKDIR /app

# Create a new POM file for the SOAP client
RUN echo '<?xml version="1.0" encoding="UTF-8"?>' > pom.xml && \
    echo '<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"' >> pom.xml && \
    echo '         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">' >> pom.xml && \
    echo '    <modelVersion>4.0.0</modelVersion>' >> pom.xml && \
    echo '    <parent>' >> pom.xml && \
    echo '        <groupId>org.springframework.boot</groupId>' >> pom.xml && \
    echo '        <artifactId>spring-boot-starter-parent</artifactId>' >> pom.xml && \
    echo '        <version>3.2.3</version>' >> pom.xml && \
    echo '        <relativePath/>' >> pom.xml && \
    echo '    </parent>' >> pom.xml && \
    echo '    <groupId>com.retail.banking</groupId>' >> pom.xml && \
    echo '    <artifactId>retail-banking-soap-client</artifactId>' >> pom.xml && \
    echo '    <version>1.0.0</version>' >> pom.xml && \
    echo '    <name>retail-banking-soap-client</name>' >> pom.xml && \
    echo '    <description>SOAP Client for Retail Banking</description>' >> pom.xml && \
    echo '    <properties>' >> pom.xml && \
    echo '        <java.version>21</java.version>' >> pom.xml && \
    echo '    </properties>' >> pom.xml && \
    echo '    <dependencies>' >> pom.xml && \
    echo '        <dependency>' >> pom.xml && \
    echo '            <groupId>org.springframework.boot</groupId>' >> pom.xml && \
    echo '            <artifactId>spring-boot-starter-web</artifactId>' >> pom.xml && \
    echo '        </dependency>' >> pom.xml && \
    echo '        <dependency>' >> pom.xml && \
    echo '            <groupId>org.springframework.ws</groupId>' >> pom.xml && \
    echo '            <artifactId>spring-ws-core</artifactId>' >> pom.xml && \
    echo '        </dependency>' >> pom.xml && \
    echo '        <dependency>' >> pom.xml && \
    echo '            <groupId>jakarta.xml.ws</groupId>' >> pom.xml && \
    echo '            <artifactId>jakarta.xml.ws-api</artifactId>' >> pom.xml && \
    echo '            <version>4.0.1</version>' >> pom.xml && \
    echo '        </dependency>' >> pom.xml && \
    echo '        <dependency>' >> pom.xml && \
    echo '            <groupId>jakarta.jws</groupId>' >> pom.xml && \
    echo '            <artifactId>jakarta.jws-api</artifactId>' >> pom.xml && \
    echo '            <version>3.0.0</version>' >> pom.xml && \
    echo '        </dependency>' >> pom.xml && \
    echo '        <dependency>' >> pom.xml && \
    echo '            <groupId>jakarta.xml.bind</groupId>' >> pom.xml && \
    echo '            <artifactId>jakarta.xml.bind-api</artifactId>' >> pom.xml && \
    echo '            <version>4.0.1</version>' >> pom.xml && \
    echo '        </dependency>' >> pom.xml && \
    echo '        <dependency>' >> pom.xml && \
    echo '            <groupId>org.projectlombok</groupId>' >> pom.xml && \
    echo '            <artifactId>lombok</artifactId>' >> pom.xml && \
    echo '            <optional>true</optional>' >> pom.xml && \
    echo '        </dependency>' >> pom.xml && \
    echo '    </dependencies>' >> pom.xml && \
    echo '</project>' >> pom.xml

COPY retail-banking-soap-client/src ./src
RUN mvn clean install -DskipTests

# Build stage for number service
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY --from=soap-client-build /root/.m2 /root/.m2
COPY retail-banking-number-service/pom.xml .
COPY retail-banking-number-service/src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/retail-banking-number-service-*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"] 