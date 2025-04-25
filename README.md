# Retail Banking Microservices Application

A modern microservices-based retail banking application built with Spring Boot, featuring multiple specialized services working together to provide a complete banking solution.

## Architecture

The application follows a microservices architecture with the following components:

### Core Services

1. **Discovery Server (Eureka)**
   - Service registry and discovery
   - Port: 8761
   - Manages service registration and health checks

2. **API Gateway**
   - Central entry point for all client requests
   - Port: 8080
   - Handles routing, load balancing, and cross-cutting concerns

3. **Account Service**
   - Manages customer accounts and transactions
   - Port: 8081
   - Persists data in MySQL database
   - Provides RESTful APIs for account operations

4. **Number Service**
   - Handles number conversion and validation
   - Port: 8083
   - Integrates with external SOAP web service
   - Provides number-related utilities

### Supporting Components

1. **MySQL Database**
   - Port: 3306
   - Stores account and transaction data
   - Configured with automatic database creation

2. **SOAP Client**
   - Handles communication with external number conversion service
   - Integrated within the Number Service
   - Uses Spring Web Services for SOAP communication

## Technology Stack

- **Java 21**
- **Spring Boot 3.2.3**
- **Spring Cloud**
  - Eureka (Service Discovery)
  - API Gateway
- **Spring Web Services**
- **MySQL 8.0**
- **Docker & Docker Compose**
- **Maven**

## Prerequisites

- Docker and Docker Compose installed
- JDK 21 (for local development)
- Maven 3.9.6 or later

## Getting Started

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd retail-banking
   ```

2. **Build and Run with Docker Compose**
   ```bash
   docker-compose up --build
   ```

   This will:
   - Build all services
   - Start MySQL database
   - Start Eureka discovery server
   - Start API Gateway
   - Start Account Service
   - Start Number Service

3. **Access the Services**
   - Eureka Dashboard: http://localhost:8761
   - API Gateway: http://localhost:8080
   - Account Service: http://localhost:8081
   - Number Service: http://localhost:8083

## Service Endpoints

### Account Service
- `POST /api/accounts` - Create new account
- `GET /api/accounts/{id}` - Get account details
- `GET /api/accounts` - List all accounts
- `POST /api/accounts/{id}/transactions` - Create transaction

### Number Service
- `GET /api/numbers/convert/{number}` - Convert number to words
- `GET /api/numbers/validate/{number}` - Validate number format

## Development

### Local Development Setup

1. **Start Required Services**
   ```bash
   docker-compose up mysql discovery-server
   ```

2. **Build Individual Services**
   ```bash
   # Build SOAP client
   cd retail-banking-soap-client
   mvn clean install

   # Build Number Service
   cd ../retail-banking-number-service
   mvn clean package

   # Build Account Service
   cd ../retail-banking-account-service
   mvn clean package
   ```

### Environment Variables

- MySQL Configuration:
  - `MYSQL_ROOT_PASSWORD`: root
  - `MYSQL_DATABASE`: retail_banking

- Account Service:
  - `SPRING_DATASOURCE_URL`: jdbc:mysql://mysql:3306/retail_banking
  - `SPRING_DATASOURCE_USERNAME`: root
  - `SPRING_DATASOURCE_PASSWORD`: root

## Architecture Diagram

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│   Client    │────▶│ API Gateway │────▶│  Services   │
└─────────────┘     └─────────────┘     └─────────────┘
                           │                   │
                           ▼                   ▼
                    ┌─────────────┐     ┌─────────────┐
                    │  Discovery  │     │   MySQL     │
                    │   Server    │     │  Database   │
                    └─────────────┘     └─────────────┘
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 