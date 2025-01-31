# Spring Boot JWT Authentication Template

## Overview  
This project provides a **secure, scalable authentication system** using **Spring Boot** and **JWT-based authentication**. It includes role-based access control, user registration, login, and refresh token functionality, following **best practices for security and modular architecture**.

## Tech Stack & Versions  
| Technology | Version |
|------------|---------|
| **Java** | 17 |
| **Spring Boot** | 3.4.2 |
| **Spring Security** | 6.x |
| **Spring Data JPA** | 3.4.2 |
| **PostgreSQL Driver** | 42.7.2 |
| **JWT (io.jsonwebtoken)** | 0.9.1 |
| **Lombok** | Latest |

---

## Project Structure  
```
src/main/java/com/example
│── auth/                  # Authentication & Security
│   ├─ CustomUserDetailService.java
│   ├─ JWTAuthenticationFilter.java
│   ├─ JwtAuthEntryPoint.java
│   ├─ JWTGenerator.java
│   └─ SecurityConfig.java
│
│── controllers/           # API Controllers
│   ├─ AuthController.java
│   └─ SelfController.java
│
│── dto/                   # Data Transfer Objects (DTOs)
│   ├─ AuthResponseDto.java
│   ├─ LoginDto.java
│   ├─ RegisterDto.java
│   ├─ RefreshTokenRequestDto.java
│   └─ UserResponseDto.java
│
│── models/                # Entity Models
│   ├─ UserEntity.java
│   └─ Role.java
│
│── repository/            # Database Access Layer
│   ├─ UserRepository.java
│   └─ RoleRepository.java
│
│── service/               # Constants and Utility
│   └─ AppConstants.java
│
└─ MaxGriffinProjectApplication.java  # Main Spring Boot Application
```

---

## Setup & Installation  

### 1. Clone the Repository  
```sh
git clone https://github.com/your-repo/jwt-auth-template.git
cd jwt-auth-template
```

### 2. Configure Database  
Edit `application.properties` and update **PostgreSQL credentials**:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build & Run  
```sh
./gradlew bootRun
```
Windows:
```sh
gradlew.bat bootRun
```

---

## Authentication Flow  
1. **Register a User** → `POST /v1/auth/register`  
2. **Login** → `POST /v1/auth/login` → Receive JWT Access & Refresh Tokens  
3. **Access Secure Endpoints** → Use `Authorization: Bearer <token>`  
4. **Refresh Token** → `POST /v1/auth/refresh`  

---

## API Endpoints  
### 🔒 Authentication  
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/v1/auth/register` | Register a new user |
| `POST` | `/v1/auth/login` | Login and get JWT token |
| `POST` | `/v1/auth/refresh` | Refresh JWT access token |

### 👤 User Management  
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/v1/@me` | Get current authenticated user |

---

## Security & Token Handling  
- **Spring Security** ensures authentication & role-based access.  
- **JWT (JSON Web Token)** for stateless authentication.  
- **Refresh Tokens** allow seamless token renewal.  
- **BCryptPasswordEncoder** encrypts user passwords.  

---

## Acknowledgments  
This project was guided and improved with the help of **ChatGPT** and **[Teddy Smith](https://github.com/teddysmithdev)** to serve as a foundation for authentication in future projects.

