# Translation Service

## 📌 Overview
The *Translation Service* is a Spring Boot-based microservice that provides translation management. It includes *JWT authentication, **H2 database for testing, and **Swagger API documentation*.

## 🚀 Features
- 🌍 Translation Management API
- 🔐 JWT-based Authentication & Authorization
- 🗄 H2 Database for Development
- 📝 Swagger UI for API Documentation
- 🐳 Docker Support

---

## 🔧 *Tech Stack*
- *Java 21*
- *Spring Boot 3.4.3*
- *Spring Security (JWT)*
- *Spring Data JPA*
- *H2 Database (for Development)*
- *Maven*
- *Docker*

---

## 🏗 *Project Setup*
### ⿡ Clone Repository
git clone https://github.com/sanaullah-techie/translation-management-system.git
## *Navigate to Project Directory*
cd translation-management-system
### *Build Docker Image*
docker build -t tms-image .
### *Run the Docker Container*

docker run -p 8080:8080 -d --name tms-container tms-image
---
### *Accessing the Application Locally*
Visit: http://localhost:8080/swagger-ui/index.html

Since the endpoints are protected by JWT authentication, users must first register and obtain a token to access protected APIs.

## *Steps to use the Swagger UI*

1 Open the Swagger UI in your browser.
2 Register a new user by providing a username and password via the /api/auth/register endpoint.
 After registration, you will receive a JWT token in the response.
3 Click on the "Authorize" button in Swagger UI and paste the received token.
4 Once authorized, you can access the protected endpoints, such as:
  Create a new translation
  Search for translations

<img width="948" alt="image" src="https://github.com/user-attachments/assets/f34bc239-7554-485e-8f39-8decef7516c3" />

![image](https://github.com/user-attachments/assets/73cf4271-1e3a-4bb2-b5cf-c0f84d14f3ec)

![image](https://github.com/user-attachments/assets/691a7afc-7168-4c81-bdbb-6765563cabe4)





