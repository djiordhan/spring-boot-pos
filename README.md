# Spring Boot POS Backend

![screen](https://github.com/djiordhan/spring-boot-pos/blob/main/demo/screen.png)
![products](https://github.com/djiordhan/spring-boot-pos/blob/main/demo/products.png)
![transactions](https://github.com/djiordhan/spring-boot-pos/blob/main/demo/transactions.png)


This is the backend repository for the [React Tailwind POS](https://github.com/djiordhan/react-tailwind-pos) project. The backend is built using Spring Boot, JPA, and PostgreSQL to handle product and transaction management.

## Features

- **Spring Boot**: A powerful framework to build production-ready applications.
- **JPA**: Java Persistence API for easy data handling.
- **PostgreSQL**: A robust and reliable relational database.

## API Endpoints

- **Products**: Fetch all products from the `/products` route.
- **Transactions**: Fetch all transactions from the `/transaction` route.

## Getting Started

### Prerequisites

- Java 11 or higher
- PostgreSQL

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/djiordhan/spring-boot-pos.git
    ```
2. Navigate to the project directory:
    ```bash
    cd spring-boot-pos
    ```
3. Configure PostgreSQL database in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```
4. Build the project:
    ```bash
    ./gradlew clean build
    ```
5. Run the application:
    ```bash
    ./gradlew bootRun
    ```

### Usage

- **Fetch Products**: 
    ```http
    GET /products
    ```
- **Fetch Transactions**: 
    ```http
    GET /transaction
    ```
