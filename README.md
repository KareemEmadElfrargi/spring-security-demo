# Spring Security Demo

This is a basic Spring Boot application demonstrating how to implement user authentication using Spring Security and JWT (JSON Web Token).

## 📚 Source & Purpose

This project is based on a Spring Security with JWT course I’m currently following.  
It's a practical implementation intended for learning purposes.

If you're also learning Spring Security, feel free to fork this repo, explore the code, and build on top of it.

## Features

- User login with username and password
- JWT token generation and validation
- Protected endpoints that require authentication
- Clean and simple structure with service layer

## Technologies Used

- Spring Boot
- Spring Security
- JWT (io.jsonwebtoken JJWT library)
- Maven

## Endpoints

- `POST /login` — authenticate user and receive JWT
- `GET /hello` — a protected endpoint (requires JWT)

## Author

Kareem Emad Elfrargi
