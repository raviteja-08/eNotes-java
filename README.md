# eNotes Management Application

Welcome to the eNotes Management Application! This application is designed to help users manage their notes efficiently. It is built using Java, JSP, Servlets, HTML, CSS, and MySQL for the database.

## Features

- **User Registration and Login**: Users can create an account and log in to manage their notes.
- **Create, Read, Update, Delete (CRUD) Operations**: Users can create new notes, view existing notes, update them, and delete them as needed.

- **User-Friendly Interface**: Simple and intuitive interface designed with HTML and CSS.

## Technologies Used

- **Java**: Core programming language used for developing the application logic.
- **JSP (JavaServer Pages)**: Used for rendering dynamic content on the web pages.
- **Servlets**: Used for handling client requests and server responses.
- **HTML & CSS**: Used for designing the frontend interface.
- **MySQL**: Database used for storing user data and notes.

## Installation

To set up the eNotes Management Application, follow these steps:

### Prerequisites

- Java Development Kit (JDK) installed
- Apache Tomcat or any other servlet container
- MySQL database server
- IDE like Eclipse or IntelliJ IDEA for Java development

### Steps

1. **Clone the Repository**: Clone the project repository to your local machine.
   ```sh
   git clone https://github.com/raviteja-08/eNotes-java.git
2. **SETUP DATABASE**: create database and tables.
   ```sh
   CREATE DATABASE eNotes;
   
   CREATE TABLE  notes  (
   id  int(5) NOT NULL,
   title  varchar(255) DEFAULT NULL,
   content  varchar(350) DEFAULT NULL,
   emailid  varchar(255) DEFAULT NULL,
   creationDate  timestamp NOT NULL DEFAULT current_timestamp(),
   updationDate  timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
   
   CREATE TABLE  userdtls  (
   id  int(11) NOT NULL,
   fullName  varchar(255) DEFAULT NULL,
   about  varchar(255) DEFAULT NULL,
   ContactNo  varchar(15) DEFAULT NULL,
   email  varchar(255) DEFAULT NULL,
   password  varchar(255) DEFAULT NULL,
   role  varchar(255) DEFAULT NULL,
   RegDate  timestamp NOT NULL DEFAULT current_timestamp()
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

   ALTER TABLE  notes ADD PRIMARY KEY ( id );
   ALTER TABLE  userdtls ADD PRIMARY KEY ( id );
   ALTER TABLE  notes MODIFY  id  int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
   ALTER TABLE  userdtls MODIFY  id  int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

