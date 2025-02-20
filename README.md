# Login-Springboot
# Authentication Service

This is a Spring Boot-based authentication service that provides user registration and login functionality. It uses JWT (JSON Web Tokens) for secure authentication and role-based access control.

## Features

- User registration with email, username, and password.
- User login with email and password.
- JWT-based authentication.
- Role-based access control (e.g., USER, ADMIN).

## Technologies Used

- **Spring Boot**: Backend framework.
- **Spring Security**: For authentication and authorization.
- **JWT (JSON Web Tokens)**: For secure token-based authentication.
- **Lombok**: For reducing boilerplate code.
- **H2 Database**: For storing user data (can be replaced with any other database).

## Setup Instructions

### Prerequisites

- Java 17 or higher.
- Maven 3.x.x.
- An IDE (e.g., IntelliJ IDEA, Eclipse).

### Steps to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/authentication-service.git
   cd authentication-service
2.**Build the Project:** 
 mvn clean install
**Run the Application:** 
mvn spring-boot:run
**Access the Application:**
The application will start on http://localhost:8080.

### Notes:
1. Replace `your-repo`, `your-secret-key`, and `your-github` with your actual repository URL, JWT secret key, and GitHub profile link.
2. If you're using a different database (e.g., MySQL, PostgreSQL), update the `application.properties` file with the appropriate configuration.
3. Add a `LICENSE` file if you want to include licensing information.
