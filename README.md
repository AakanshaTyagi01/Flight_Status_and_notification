# Flight_Status_and_notification
this shows current flight status and send notification to the customer for any flight changes.
# Flight Status Dashboard

This is a Spring Boot application for tracking flight statuses. It allows users to sign up, log in, and check the status of their flights. The application also provides notifications via Kafka.

## Features

- User signup and login
- Fetch flight status from an external API (AviationStack)
- Display flight statuses
- Notifications using Kafka
- REST API for managing flight statuses

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Spring Security
- Spring Kafka
- React
- Axios

## Prerequisites

- JDK 17
- Maven
- PostgreSQL
- Node.js and npm
- Kafka and Zookeeper

## Getting Started

### Backend

1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   cd flightstatus
2. **Configure PostgreSQL:**

Create a database named flightstatusdb.
Update the database username and password in src/main/resources/application.properties.

3. **Install dependencies and build the project:**
mvn clean install

4. **Run the application:**
mvn spring-boot:run

5. **Verify the application is running:**
Open a web browser and go to http://localhost:8080

Frontend
1. **Navigate to the frontend directory:**
cd flight-status

2. **Install dependencies:**
npm install

3. **Start the frontend development server:**
npm start

4. **Verify the frontend is running**
Open a web browser and go to http://localhost:3000

Kafka
1. **Start Zookeeper:**
bin/zookeeper-server-start.sh config/zookeeper.properties

2.  **bin/kafka-server-start.sh config/server.properties**

Project Structure

Backend

src/main/java/com/example/flightstatus

FlightStatusApplication.java: Main class to run the Spring Boot application.

controller: Contains the REST controllers.

service: Contains the business logic.

repository: Contains the JPA repositories.

model: Contains the entity classes.

config: Contains the configuration classes.


Frontend

flight-status/src

components: Contains the React components.

styles.css: Contains the CSS for the application.

App.js: Main React component.

index.js: Entry point for the React application.


Contributing

Fork the repository
Create your feature branch (git checkout -b feature/your-feature)
Commit your changes (git commit -m 'Add some feature')
Push to the branch (git push origin feature/your-feature)
Create a new Pull Request

