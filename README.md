# Car Service Fuel Tracker
 
Overview
The Car Fuel and Service Tracker is a Spring Boot-based web application designed to help car owners efficiently manage and track their car's service history and fuel expenses. It provides APIs to add, update, view, and delete records related to car services and fuel refills. The project employs a MySQL database for persistent data storage, ensuring that the application maintains a robust and scalable structure.

Features
Car Service Management

Add service details like date, type, cost, and service center.
Retrieve all service records or a single record by ID.
Update existing service records.
Delete a service record.
Fuel Records Management

Add fuel refill details like date, liters filled, price per liter, total cost, and odometer reading.
Retrieve all fuel refill records or a specific record by ID.
Update existing fuel refill records.
Delete a fuel refill record.
Error Handling

Centralized error handling with descriptive messages for a better API user experience.
API Endpoints

RESTful API endpoints for seamless integration with other systems or frontend applications.
Technologies Used
Backend Framework: Spring Boot (3.4.1)
Database: MySQL
ORM: Hibernate
Dependencies:
Spring Data JPA
HikariCP for connection pooling
Spring Web for REST APIs
Development Environment: Java 17 or later (JDK 21 recommended)



Prerequisites
Java Development Kit (JDK): Version 17 or higher.
MySQL: Version 8.0 or higher.
Postman: For testing API endpoints (optional).
Maven: For managing project dependencies.
