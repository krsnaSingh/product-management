
# Product CRUD Application

## Overview

The Product CRUD Application is a web application built using Spring MVC and JDBC, designed to demonstrate the implementation of basic Create, Read, Update, and Delete (CRUD) operations. Users can manage product information stored in a MySQL database, allowing for effective inventory management. The application employs XML configuration for the Spring framework, providing practical experience with its architecture and core components.

## Features

- **Create**: Add new products to the inventory.
- **Read**: View a list of all products with their details.
- **Update**: Modify existing product information.
- **Delete**: Remove products from the inventory.

## Technologies Used

- **Java**: The primary programming language for backend development.
- **Spring MVC**: Framework utilized for building the web application.
- **JDBC**: Used for database connectivity and operations.
- **MySQL**: Relational database to store product information.
- **JSP**: JavaServer Pages for creating dynamic web content.
- **Maven**: Tool for dependency management and project structuring.

## Project Structure

The project consists of several important components:

- **Controller**: Handles HTTP requests and manages application flow.
- **DAO (Data Access Object)**: Manages database operations for product entities.
- **Service**: Contains business logic related to product management.
- **Mapper**: Maps SQL query results to product objects.
- **Model**: Represents product data.
- **Exception**: Custom exceptions for error handling.
- **Views**: JSP files for the user interface, including:
  - `product-list.jsp`: Displays the list of products.
  - `product-form.jsp`: Form for adding new products.
  - `product-edit.jsp`: Form for editing existing products.
  - `error.jsp`: Generic error page.

The Spring configuration file, `spring-servlet.xml`, defines beans and sets up the application context, while the `web.xml` file configures the web application.

## Setup Instructions

To set up and run the application, follow these steps:

### Prerequisites

Ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- MySQL Database Server
- Eclipse IDE or Spring Tool Suite (STS)

### Step 1: Clone the Repository

Clone the project repository from GitHub:

```bash
git clone https://github.com/krsnaSingh/product-management.git
```

### Step 2: Set Up Database

1. **Create a Database**:
   Open MySQL Workbench or any MySQL client and create a new database named `productdb`.

2. **Create a Products Table**:
   Run the following SQL script to create the required table:

   ```sql
   CREATE TABLE Product (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       price DECIMAL(10, 2) NOT NULL,
       description TEXT
   );
   ```

### Step 3: Update Database Credentials

Open the `spring-servlet.xml` file and update the database connection details:

```xml
<bean id="ds" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
    <property name="url" value="jdbc:mysql://localhost:3306/productdb" />
    <property name="username" value="your-username" />
    <property name="password" value="your-password" />
</bean>
```

### Step 4: Build the Project

Navigate to the project directory and run:

```bash
mvn clean install
```

### Step 5: Run the Application

Deploy the application on a servlet container (like Apache Tomcat) and access it at `http://localhost:8080/productcrudapp/products`.

## Learning Outcomes

Through the development of the Product CRUD application, several valuable lessons and skills were acquired:

1. **Understanding Spring MVC**: Gained a comprehensive understanding of the Model-View-Controller (MVC) architecture, specifically how Spring MVC facilitates the separation of concerns.

2. **Spring Configuration**: Learned to configure the Spring framework using XML.

3. **Database Interactions**: Developed skills in using JDBC for database operations, enhancing my ability to connect to a MySQL database and perform CRUD operations effectively.

4. **JSP and Web Development**: Improved proficiency in JavaServer Pages (JSP) for creating dynamic web content and utilizing JSTL for simplifying the development of web interfaces.

5. **Error Handling**: Implemented custom exception handling, such as the `ProductNotFoundException`, which helped in understanding how to manage application errors gracefully.


## Challenges Faced

During the development and configuration of the Product CRUD application, several challenges were encountered:

1. **Dependency Management**: Ensuring compatibility among different libraries in the Maven configuration was crucial to prevent version conflicts.

2. **JSP Configuration**: Correctly defining paths for JSP views in the configuration was essential to render the pages accurately.


## Conclusion

This Product CRUD application serves as a practical demonstration of Spring MVC and JDBC principles. It provides an effective way to implement a web application with basic CRUD operations and offers valuable insights into configuring and using the Spring framework. 



