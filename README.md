🚀 Java Functional Programming & JUnit 5 Portfolio Project

Modern Java • Clean Architecture • Professional Testing

This repository showcases a collection of production-style Java assignments built using modern Java (Java 21) and JUnit 5.
It demonstrates functional programming concepts, clean service-layer design, and robust unit testing, following industry best practices.

📌 Designed as a portfolio-ready project to reflect real-world Java development skills.

✨ Highlights

✅ Modern Java 21 (not legacy Java 8)

✅ Functional programming with Streams, Lambdas, Optional

✅ Clean separation of model, service, and test layers

✅ Extensive JUnit 5 test coverage

✅ Edge cases & exception handling included

✅ Maven-based, IDE-friendly structure

🛠 Tech Stack

Java 21

JUnit 5

Maven

Stream API

Lambda Expressions

Functional Interfaces

Optional

IntelliJ IDEA

📁 Project Structure
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── org
│   │           └── example
│   │               ├── model
│   │               │   ├── Employee.java
│   │               │   ├── Order.java
│   │               │   ├── Product.java
│   │               │   └── User.java
│   │               └── service
│   │                   ├── EmployeeService.java
│   │                   ├── OrderService.java
│   │                   ├── ProductService.java
│   │                   └── UserRepository.java
│   └── test
│       └── java
│           └── org
│               └── example
│                   └── service
│                       ├── EmployeeServiceTest.java
│                       ├── OrderServiceTest.java
│                       ├── ProductServiceTest.java
│                       └── UserRepositoryTest.java
└── target

The structure mirrors real enterprise Java applications, making the codebase easy to navigate and maintain.

🧩 Implemented Modules
1️⃣ Employee Stream Filter

Concepts: Streams, filtering, mapping

Features

Filters employees with salary > ₹50,000

Maps results to employee names

Handles empty datasets safely

Skills Demonstrated

Stream pipelines

Functional transformations

Clean collection handling

2️⃣ Product Discount with Lambda

Concepts: Lambda expressions, functional interfaces

Features

Applies discounts using Function<Product, Double>

Supports dynamic discount strategies

Validates invalid and negative prices

Skills Demonstrated

Strategy pattern via lambdas

Functional abstraction

Defensive programming

3️⃣ Optional User Lookup

Concepts: Optional, null safety

Features

Returns Optional<User> instead of null

Safe retrieval using orElse, isPresent

Exception-safe access patterns

Skills Demonstrated

Null-safe design

Clean API contracts

Modern Java best practices

4️⃣ Order Processing with Streams

Concepts: Aggregation, filtering

Features

Calculates total order value

Filters orders above a threshold

Handles empty and negative values

Skills Demonstrated

Stream aggregation

Business-rule filtering

Data validation

5️⃣ Student Grade Management (Core Java + JUnit)

Concepts: State management, parameterized tests

Includes

StudentGradeCalculator

MultiStudentGradeManager

Parameterized testing with:

@ValueSource

@CsvSource

@MethodSource

Skills Demonstrated

Object-oriented design

JUnit 5 advanced testing

Multi-scenario validation

6️⃣ Utility Modules

PasswordValidator → Regex & validation rules

BankAccount → Transaction safety & exception handling

TemperatureConverter → Mathematical correctness

ShoppingCart → State consistency & error handling

🧪 Testing Philosophy

Every module is backed by comprehensive JUnit 5 tests.

✔ Positive cases
✔ Edge cases
✔ Invalid input handling
✔ Exception validation
✔ Empty-state scenarios

Example

assertThrows(IllegalArgumentException.class, () -> service.deposit(-100));
▶️ How to Run
mvn clean test

All tests execute automatically using JUnit 5.

🎯 Why This Project Matters

This repository demonstrates:

Real-world Java service design

Strong understanding of functional programming

Clean and maintainable test-driven development

Readiness for interviews, internships, and entry-level roles

💡 This project is intentionally structured to reflect how Java is written and tested in professional environments.

👤 Author

Andrea Narcis
