

# Spring Boot Application

This is a Spring Boot application that provides an API for managing shopping carts. The application uses a MySQL database to store cart items and user information.

## Prerequisites

Before running the application, you need to have a MySQL database set up and create a `shopping_cart` database. You can use the following command to create the database:

```
mysql -u username -p -e "CREATE DATABASE shopping_cart;"
```

Replace `username` with your MySQL username.

## Running the Application

To run the application, you can use the following command:

```
mvn spring-boot:run
```

This will start the application on port 5000 by default.

edit the `application.yml` file to configure the application as you need. 