Food Orders Service

🍔 Spring Boot REST API for Food Delivery Orders

This is a minimal backend service built with Spring Boot and MySQL to simulate the processing of food delivery orders. It includes REST APIs to place orders and retrieve them with pagination.



⚙️ Tech Stack

Java 17 \& Spring Boot 3: For building the backend service.



MySQL: For persistent data storage.



JPA + Hibernate: For database interactions.



Flyway: For managing database schema migrations.



Swagger UI: For interactive API documentation.



🚀 Quick Start

1\. Create Database

First, create the database in your MySQL instance.



CREATE DATABASE food\_orders\_db CHARACTER SET utf8mb4 COLLATE utf8mb4\_0900\_ai\_ci;



2\. Update Configuration

Open src/main/resources/application.properties and update the database credentials.



spring.datasource.url=jdbc:mysql://localhost:3306/food\_orders\_db

spring.datasource.username=root

spring.datasource.password=your\_password

spring.flyway.enabled=true



3\. Run Application

Navigate to the project's root directory and run the application using Maven.



mvn spring-boot:run



The application will start on port 8080.



App URL: http://localhost:8080



Swagger UI: http://localhost:8080/swagger-ui/index.html



📡 API Examples

Place an Order

POST /api/orders



Body (JSON):



{

&nbsp; "customerName": "Harshi",

&nbsp; "items": \[

&nbsp;   {"name":"Veg Burger","quantity":2,"unitPrice":89.5},

&nbsp;   {"name":"French Fries","quantity":1,"unitPrice":59.0}

&nbsp; ],

&nbsp; "totalAmount": 238.0,

&nbsp; "orderTime": "2025-09-09T09:30:00Z"

}



Get All Orders (Paged)

GET /api/orders?page=0\&size=5\&sort=orderTime,desc



Sample Response:



{

&nbsp; "id": 1,

&nbsp; "customerName": "Harshi",

&nbsp; "items": \[

&nbsp;   {"name":"Veg Burger","quantity":2,"unitPrice":89.5},

&nbsp;   {"name":"French Fries","quantity":1,"unitPrice":59.0}

&nbsp; ],

&nbsp; "totalAmount": 238.0,

&nbsp; "orderTime": "2025-09-09T09:30:00Z"

}



📌 Important Notes

Ensure your MySQL service is running before you start the application.



Use a tool like Postman or cURL to test the API endpoints.



The items column is stored as JSON to keep the schema simple. A separate relational table would be needed if you required advanced queries on individual items.



The indexes on order\_time and customer\_name are crucial for efficient sorting and filtering.

