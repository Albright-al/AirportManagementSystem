# ✈️ Airport Management System

> **OOP Java Assignment** — A console-based Airport Management System built with core Object-Oriented Programming principles.

---

## 📌 Project Overview

This system simulates a real airport workflow from passenger check-in to boarding, covering:

- Passenger registration & validation
- Flight creation using a **Factory Pattern**
- Ticket booking & seat/class selection
- Reservation confirmation
- Security check processing
- Payment handling (Cash / Card / Online)
- Baggage check-in
- Gate assignment & Boarding Pass generation
- Notifications
- Report generation (flights, passengers, revenue, delays)
- Staff & Airport management

---

## 🏗️ Project Structure

```
AirportManagementSystem/
├── src/
│   └── main/
│       └── java/
│           └── airport/
│               ├── AirportSystem.java       ← Main entry point
│               ├── AirportEntity.java
│               ├── Airport.java
│               ├── AirportManager.java
│               ├── Flight.java
│               ├── FlightFactory.java
│               ├── FlightSubclasses.java
│               ├── Passenger.java
│               ├── Ticket.java
│               ├── Reservation.java
│               ├── BoardingPass.java
│               ├── Staff.java
│               ├── SupportClasses.java
│               ├── ReportGenerator.java
│               ├── InputValidator.java
│               ├── Payable.java
│               ├── Reservable.java
│               └── Trackable.java
├── Dockerfile
└── README.md
```

---

## ⚙️ OOP Concepts Demonstrated

| Concept | Where Used |
|---|---|
| **Inheritance** | `Flight`, `Staff`, `AirportEntity` subclasses |
| **Polymorphism** | `FlightFactory` creates different flight types |
| **Encapsulation** | Private fields + getters/setters in all classes |
| **Abstraction** | `Payable`, `Reservable`, `Trackable` interfaces |
| **Factory Pattern** | `FlightFactory.createFlight(...)` |

---

## 🐳 Running with Docker

### Prerequisites
- [Docker](https://www.docker.com/) installed on your machine

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/<your-username>/AirportManagementSystem.git
cd AirportManagementSystem
```

**2. Build the Docker image** (this also compiles the code and builds the JAR)
```bash
docker build -t airport-management-system .
```

**3. Run the application**
```bash
docker run -it airport-management-system
```

> The `-it` flag is required because the program reads input from the keyboard interactively.

---

## ☕ Running Locally (without Docker)

### Prerequisites
- Java JDK 17 or higher

### Steps

```bash
# Compile
javac -d out/classes src/main/java/airport/*.java

# Package into JAR
jar cfm AirportManagementSystem.jar MANIFEST.MF -C out/classes .

# Run
java -jar AirportManagementSystem.jar
```

---

## 👨‍💻 Author

- **Course:** Object-Oriented Programming
- **Language:** Java 21
