# Faktorize

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://mysql.com/)

Invoice management system developed in Java with Spring Boot. Allows complete CRUD operations for invoices, suppliers, and customers, with MySQL database persistence.

## 📋 Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## ✨ Features

- 📄 Complete invoice management (Invoice)
- 🏢 Supplier management (Supplier)
- 👥 Customer management (Customer)
- 🔄 Complete CRUD operations for all entities
- 🗄️ Persistence with JPA/Hibernate
- 🔗 Well-structured RESTful API
- 📊 MySQL database
- 🏗️ Layered architecture (Repository, Service, Controller)

## 🏗️ Architecture

The project follows a well-defined layered architecture:

```
src/main/java/
├── models/         # JPA entities (Invoice, Supplier, Customer)
├── dtos/           # Data Transfer Objects
├── service/        # Business logic
├── repository/     # Data access layer
└── controller/     # REST controllers (implicit)
```

## 🔧 Prerequisites

Before getting started, make sure you have installed:

- [Java 17+](https://openjdk.org/)
- [Maven 3.8+](https://maven.apache.org/)
- [MySQL 8.0+](https://mysql.com/)
- [Git](https://git-scm.com/)

## 🚀 Installation

1. Clone the repository:
```bash
git clone https://github.com/antonio-macave/faktorize.git
```

2. Navigate to the project directory:
```bash
cd faktorize
```

3. Install dependencies:
```bash
mvn clean install
```

## ⚙️ Configuration

### MySQL Database

1. Create a MySQL database:
```sql
CREATE DATABASE faktorize;
```

2. Configure the `application.properties` file:
```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/faktorize
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Server configuration
server.port=8080
```

## 📖 Usage

### Running the application

```bash
# Run with Maven
mvn spring-boot:run

# Or run the compiled JAR
java -jar target/faktorize-1.0.0.jar
```

The application will be available at `http://localhost:8080`

### Testing the API

You can use tools like Postman, curl, or any HTTP client to test the endpoints.

## 🌐 API Endpoints

### Invoices
- `GET /api/invoices` - List all invoices
- `GET /api/invoices/{id}` - Get invoice by ID
- `POST /api/invoices` - Create new invoice
- `PUT /api/invoices/{id}` - Update invoice
- `DELETE /api/invoices/{id}` - Delete invoice

### Suppliers
- `GET /api/suppliers` - List all suppliers
- `GET /api/suppliers/{id}` - Get supplier by ID
- `POST /api/suppliers` - Create new supplier
- `PUT /api/suppliers/{id}` - Update supplier
- `DELETE /api/suppliers/{id}` - Delete supplier

### Customers
- `GET /api/customers` - List all customers
- `GET /api/customers/{id}` - Get customer by ID
- `POST /api/customers` - Create new customer
- `PUT /api/customers/{id}` - Update customer
- `DELETE /api/customers/{id}` - Delete customer

## 🛠️ Technologies Used

- **Java 17+** - Programming language
- **Spring Boot 3.5.0** - Main framework
- **Spring Data JPA** - Data persistence
- **MySQL** - Database
- **Maven** - Dependency management
- **Hibernate** - ORM (Object-Relational Mapping)

## 🤝 Contributing

Contributions are welcome! Follow these steps:

1. Fork the project
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Contribution guidelines

- Follow Java code conventions
- Add unit tests for new features
- Update documentation when necessary
- Make sure all tests pass

## 📝 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## 📞 Contact

António Macave - [@antonio-macave](https://github.com/antonio-macave)

Project Link: [https://github.com/antonio-macave/faktorize](https://github.com/antonio-macave/faktorize)

---

⭐ If this project was helpful to you, consider giving it a star!