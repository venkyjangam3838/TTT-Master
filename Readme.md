# Customer & Coach Management API

A **Spring Boot REST API** for managing customers and coaches, including fetching, adding, and retrieving details using **Spring Data JPA**.

## Table of Contents📚

1. [Introduction🚀](#introduction)  
2. [Features🛠️](#features)  
3. [Tech Stack⚙️](#tech-stack)  
4. [API Endpoints🔗](#api-endpoints)  
5. [Getting Started🎯](#getting-started)  
6. [Prerequisites📋](#prerequisites)  
7. [Installation⚙️](#installation)  
8. [Usage📈](#usage)  
9. [Contributing❤️](#contributing)  
10. [License📝](#license)  

## Introduction🚀  

This API allows users to **manage customers and coaches** by providing endpoints for fetching, adding, and retrieving details based on unique identifiers.

## ScreenShot📷

![Screenshot_1](https://github.com/BoddepallyVenkatesh06/POC_Maven_Project/blob/main/1.png)
![Screenshot_2](https://github.com/BoddepallyVenkatesh06/POC_Maven_Project/blob/main/2.png)
![Screenshot_3](https://github.com/BoddepallyVenkatesh06/POC_Maven_Project/blob/main/3.png)
![Screenshot_4](https://github.com/BoddepallyVenkatesh06/POC_Maven_Project/blob/main/4.png)
![Screenshot_5](https://github.com/BoddepallyVenkatesh06/POC_Maven_Project/blob/main/5.png)

## Features🛠️  

- **Customer Management**  
  - Fetch all customers  
  - Fetch a specific customer by ID  
  - Add a new customer  

- **Coach Management**  
  - Fetch all coaches  
  - Fetch a specific coach by ID  
  - Add a new coach  

## Tech Stack⚙️  

- **Spring Boot** - Backend framework  
- **Spring Data JPA** - Database integration  
- **H2 / PostgreSQL / MySQL** - Database options  
- **Spring Web** - REST API support  
- **Lombok (Optional)** - Reduces boilerplate code  
- **Postman (For Testing)** - API Testing  

## API Endpoints🔗  

### Customer API  

| Method | Endpoint            | Description             |
|--------|---------------------|-------------------------|
| GET    | `/api/customers`    | Get all customers      |
| GET    | `/api/customers/{id}` | Get customer by ID  |
| POST   | `/api/customers`    | Add a new customer     |

### Coach API  

| Method | Endpoint         | Description          |
|--------|-----------------|----------------------|
| GET    | `/api/coaches`  | Get all coaches     |
| GET    | `/api/coaches/{id}` | Get coach by ID |
| POST   | `/api/coaches`  | Add a new coach     |

## Getting Started🎯  

Follow these steps to set up the project locally.

## Prerequisites📋  

- **Java 17+**  
- **Maven**  
- **Spring Boot**  
- **H2/PostgreSQL/MySQL** (Optional, based on DB choice)  

## Installation⚙️  

1. Clone the repository:  
   ```bash
   git clone https://github.com/BoddepallyVenkatesh06/POC_Maven_Project.git
   cd customer-coach-api
   ```

2. Install dependencies:  
   ```bash
   mvn clean install
   ```

3. Run the application:  
   ```bash
   mvn spring-boot:run
   ```

4. Access the API at `http://localhost:8080`

## Usage📈  

- Use **Postman** or **cURL** to interact with the API.  
- Example request to **add a customer**:  

  ```json
  POST /api/customers
  Content-Type: application/json

  {
    "id": 1,
    "height": 180,
    "weight": 75,
    "coach": {
      "id": 101,
      "height": 185,
      "weight": 80
    }
  }
  ```

## Contributing❤️  

1. Fork the repository  
2. Create a new branch (`git checkout -b feature-branch`)  
3. Commit your changes (`git commit -m "Added new feature"`)  
4. Push the branch (`git push origin feature-branch`)  
5. Submit a Pull Request  

## License📝  

MIT License  

```plaintext
MIT License

Copyright (c) 2024 Venky Kumar

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```