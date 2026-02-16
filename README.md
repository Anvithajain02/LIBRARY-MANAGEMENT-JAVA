# Library Management System (Java + Swing + JDBC)

## Overview

This project is a desktop-based Library Management System developed using **Java**, **Swing**, **JDBC**, and **MySQL**.
It helps manage books, issue and return operations, and track pending books and fines.

---

## Features

* Add new books
* View all books
* Search books
* Delete books
* Issue books
* Return books
* Fine calculation for late returns
* View issued books
* View pending books
* Dashboard showing statistics

---

## Technologies Used

* Java (Core Java, OOP)
* Swing (GUI)
* JDBC (Database connectivity)
* MySQL (Database)

---

## Project Structure

src/
├── dao          # Database access classes
├── db           # Database connection
├── model        # Entity classes
├── ui           # Swing UI screens
└── Main.java    # Entry point

---

## Database Setup

Create database:

```sql
CREATE DATABASE librarydb;
```

Create tables:

```sql
CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    category VARCHAR(50),
    quantity INT
);

CREATE TABLE issued_books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    student_name VARCHAR(100),
    issue_date DATE,
    return_date DATE,
    fine DOUBLE DEFAULT 0
);
```

---

## How to Run

1. Install MySQL and create database
2. Update DB username and password in `DBConnection.java`
3. Open project in IntelliJ IDEA
4. Run `Main.java`

---

## Future Improvements

* Login roles (Admin / Librarian)
* Export reports
* Improved dashboard UI

---

## Author

Anvitha Jain
