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
### *Access Swagger UI*
Visit http://localhost:8080/swagger-ui/index.html


