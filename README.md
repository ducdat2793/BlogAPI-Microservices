Blog API Microservices
Blog API Microservices is a blog management application using Spring Boot, Spring Security, and Microservices Architecture. The application includes the following services:

API Gateway
User Service
Post Service

The application uses Feign Client to communicate between microservices and Swagger UI to test the API via the API Gateway.

📌 Key Features
Spring Boot: Used for all microservices.
Spring Security: Ensures security for the APIs.
Microservices Architecture: For a distributed system with independent services.
API Gateway: A single entry point for external requests, helping with routing and security.
Swagger UI: Integrated for easy testing and interacting with the APIs.
Feign Client: Used for inter-service API calls between microservices.
Exception Handling: Centralized error handling through @ControllerAdvice.
CRUD Operations: Microservices perform basic CRUD operations (Create, Read, Update, Delete) with the database.
H2 Database: Used for data storage in the development environment.

🚀 System Architecture
The system consists of 3 main parts:
API Gateway: Acts as a single entry point and routes requests to the appropriate services.
User Service: Manages user information, registration, login, and user authentication.
Post Service: Manages blog posts, including CRUD operations for user posts.

🔧 Setup and Run the Application
1. Clone the Repo
```
git clone https://github.com/ducdat2793/BlogAPI-Microservices.git
cd BlogAPI-Microservices
```
2. Set Up the Microservices
```
cd api-gateway
mvn spring-boot:run
```
API Gateway will run on port 8080.
```
cd user-service
mvn spring-boot:run
```
User Service will run on port 8081.
```
cd post-service
mvn spring-boot:run
```
Post Service will run on port 8082.

3. Test the API
Use Swagger UI to test the API at the following address:
http://localhost:8080/webjars/swagger-ui/index.html

⚠️ Common Issues
503 Service Unavailable: Check that the services are running. Make sure that the services (user-service, post-service, api-gateway) are correctly started and listening on the appropriate ports.
403 Forbidden: Check that the JWT token is valid and is being sent properly in the Authorization header.
