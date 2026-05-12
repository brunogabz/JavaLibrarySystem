# Library Management System

This is a personal project developed for training purposes, focusing on software architecture, database persistence, and access control. The system manages a library's collection and handles user authentication with different privilege levels.

## Features
- **User Authentication:** Secure Login and Sign Up system.
- **Role-Based Access Control (RBAC):** Differentiation between standard users (`USER`) and administrators (`ADMIN`).
- **Book Management:** Administrators can register new books, while all users can list the collection.
- **Database Integration:** Full persistence using PostgreSQL and JDBC.

## Technologies Used
- **Java** (JDK 17+)
- **PostgreSQL** (Relational Database)
- **Maven** (Dependency Management)
- **JDBC** (Java Database Connectivity)

## Database Setup
To run this project on a different machine, you need to set up the following tables in your PostgreSQL environment:

```sql
-- Create Users Table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,(url)(url)
    password VARCHAR(150) NOT NULL,
    role VARCHAR(20) DEFAULT 'USER'
);

-- Create Books Table
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(150) NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    publication_year INT
);

-- Note: To promote a user to Admin, execute:
-- UPDATE users SET role = 'ADMIN' WHERE email = 'user@example.com';
