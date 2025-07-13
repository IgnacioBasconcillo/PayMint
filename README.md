# PayMint
"Just an API to manage payments"

**Paymint** is an educational project that simulates the core logic of a **payment gateway**. It's designed to demonstrate modern backend practices within a modular monolithic architecture.

> ⚠️ **Disclaimer**: This project is not intended for production use. In a real-world scenario, the application would be implemented using **multiple microservices** for scalability, resilience, and separation of concerns. This monolithic version is meant for **learning and experimentation purposes only**.

---

## 🧠 Key Features

- **Modular monolith** structure
- **Hexagonal architecture** (Ports and Adapters)
- **Domain-Driven Design (DDD)** principles
- **Command-based use case orchestration**
- **CQRS (Command Query Responsibility Segregation)**
- **PostgreSQL** as the relational database
- **Docker Compose** support for easy local deployment
- Clean separation between technical and business concerns

---

## 📦 Module Structure

The project is divided into the following modules:

- `application`: Contains command handlers.
- `build`: Build configuration and dependency management.
- `common`: Shared classes such as commands logic, enums, exceptions, utilities, and base types.
- `domain`: Core business logic, aggregates, entities, and value objects.
- `infrastructure`: Persistence (e.g. repositories), configuration, and external system integrations (e.g. PostgreSQL, Spring Boot adapters).

Each module follows the **hexagonal architecture** principle to isolate business logic from frameworks and infrastructure.

---

## 🐳 Running the Project

To run the application along with a PostgreSQL database, use the provided **Docker Compose** file:

docker-compose up --build
