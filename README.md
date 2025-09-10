Food Orders Service

🍔 Spring Boot REST API for Food Delivery Orders

A simplified backend service that simulates processing of food delivery orders using Java, Spring Boot, and MySQL.

![Java](https://img.shields.io/badge/Java-17-blue) 
![Spring Boot](https://img.shields.io/badge/SpringBoot-3-brightgreen) 
![MySQL](https://img.shields.io/badge/Database-MySQL-orange)

⚙️ Tech Stack

Java 17 \& Spring Boot 3: For building the backend service.



MySQL: For persistent data storage.



JPA + Hibernate: For database interactions.



Flyway: For managing database schema migrations.



Swagger UI: For interactive API documentation.



🚀 Quick Start

1. Create Database

First, create the database in your MySQL instance.


```sql
CREATE DATABASE food\_orders\_db CHARACTER SET utf8mb4 COLLATE utf8mb4\_0900\_ai\_ci;
```


2. Update Configuration

Open src/main/resources/application.properties and update the database credentials.
```sql
spring.datasource.url=jdbc:mysql://localhost:3306/food\_orders\_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.flyway.enabled=true
```


3. Run Application

Navigate to the project's root directory and run the application using Maven.

`mvn spring-boot:run`

The application will start on port 8080.



App URL: `http://localhost:8080`



Swagger UI: `http://localhost:8080/swagger-ui/index.html`



📡 API Examples

Place an Order

POST `/api/orders`



Body (JSON):


```json

{
  "customerName": "Harshi",
  "items": [
    {"name":"Veg Burger","quantity":2,"unitPrice":89.5},
    {"name":"French Fries","quantity":1,"unitPrice":59.0}
  ],
  "totalAmount": 238.0,
  "orderTime": "2025-09-09T09:30:00Z"
}
```


Get All Orders (Paged)

GET `/api/orders?page=0\&size=5\&sort=orderTime,desc`



Sample Response:
```
{

 "id": 1,

 "customerName": "Harshi",

 "items": \[

 {"name":"Veg Burger","quantity":2,"unitPrice":89.5},

  {"name":"French Fries","quantity":1,"unitPrice":59.0}

 ],

 "totalAmount": 238.0,

 "orderTime": "2025-09-09T09:30:00Z"

}
```


📌 Important Notes

Ensure your MySQL service is running before you start the application.
Use a tool like Postman or cURL to test the API endpoints.
The items column is stored as JSON to keep the schema simple. A separate relational table would be needed if you required advanced queries on individual items.
The indexes on order\_time and customer\_name are crucial for efficient sorting and filtering.

