#  Flight Reservation System — Java 8

A simple Java-based flight reservation system that allows users to:

- Search flights by destination and date  
- Book flights  
- View all reservations  
- Run basic unit tests (JUnit)

---

##  How to Run the Application

### **Requirements**
- Java 8 or higher installed on your system

### **Compile the project**
Open terminal inside the project directory and run:

---

##  Project Structure

flight-reservation-system/
├── src/
│ ├── main/java/com/example/flight/
│ │ ├── Flight.java
│ │ ├── Reservation.java
│ │ ├── FlightService.java
│ │ └── FlightReservationApp.java
│ └── test/java/com/example/flight/
│ └── FlightServiceTest.java
├── README.md

---

##  Design Decisions

###  1. Object-Oriented Approach  
The system is designed using standard OOP principles:
- `Flight` → Represents flight information  
- `Reservation` → Represents a flight booking  
- `FlightService` → Handles search and booking logic  
- `FlightReservationApp` → Console interface  

###  2. Java 8 Streams  
Used Streams for clean and readable filtering of flights and reservations.

###  3. In-Memory Storage  
Used Lists (ArrayList) to store flights and reservations to keep the project simple.

###  4. Validation  
Before booking:
- Checks seat availability  
- Prevents overbooking  
- Ensures reservations are stored correctly  

###  5. Separation of Concerns  
Business logic is separated from UI logic to keep code maintainable.

---

##  Real-Life Considerations

In a production environment:

### 1. **Database Storage**
The system would connect to a real database instead of in-memory lists.

### 2. **Thread Safety**
Flight booking would require synchronization to prevent race conditions.

### 3. **Error Handling & Logging**
Production systems must include robust logging and error management.

### 4. **Scalability**
The system could be split into microservices:
- Flight Service  
- Inventory Service  
- Booking Service  
- Notification Service  

### 5. **Search Optimization**
Indexes or caching layers (e.g., Redis) would improve search speed at scale.

---

##  Unit Testing
Unit tests (JUnit) verify:
- Flight search by date & destination  
- Booking success when seats are available  
- Booking failure when seats are insufficient  

Run tests:
mvn test

---

##  Author  
**Nalini Eerla**


