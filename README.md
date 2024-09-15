# Groceries Backend API

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=groceries-api&metric=coverage)](https://sonarcloud.io/summary/new_code?id=ThiagoSousaSantana_groceries)

## Overview

This project is a backend API designed to manage grocery shopping lists and monthly grocery spending in a smart and efficient way. It is developed using Spring and Kotlin, and it uses a PostgreSQL database.

## Features

- Manage grocery shopping lists
- Track monthly grocery spending
- Smart recommendations for grocery shopping
- RESTful API endpoints

## Technologies Used

- **Kotlin**: The primary programming language used for development.
- **Spring Framework**: Used for building the backend services.
- **PostgreSQL**: The database used for storing data.
- **Gradle**: The build tool used for managing dependencies and building the project.

## Getting Started

### Prerequisites

- JDK 21 or higher
- Gradle
- PostgreSQL

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/ThiagoSousaSantana/groceries.git
    cd groceries
    ```

2. Configure the PostgreSQL database in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3. Build the project:
    ```sh
    ./gradlew build
    ```

4. Run the application:
    ```sh
    ./gradlew bootRun
    ```

## Running Tests

To run the tests, use the following command:
```sh
./gradlew test