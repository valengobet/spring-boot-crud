# Spring Boot CRUD API - Anime Management
A simple CRUD API built using Spring Boot, MySQL, JPA, and Hibernate. This project is designed as a learning exercise for basic backend development concepts.

### Features
- RESTful CRUD operations for managing anime records.
- Integration with MySQL as the database.
- Modular architecture with Controller, Service, and Repository layers.
- API documentation with Swagger UI.


### Steps to Setup
1. Clone the repository
   ```
   git clone https://github.com/valengobet/spring-boot-crud.git
   cd spring-boot-crud
   ```

2. Create the MySQL database
Log in to MySQL and create the database:
   ```
   Copy code
   CREATE DATABASE crud;
   Ensure the database connection matches your environment settings.
   ```

3. Update database credentials
   1. Open the file src/main/resources/application.properties.
   2. Modify the following properties with your MySQL username and password:
      ```
      spring.datasource.url=jdbc:mysql://localhost:3306/crud
      spring.datasource.username=your_mysql_username
      spring.datasource.password=your_mysql_password
      ```

4. Run the application
You can run the app using Maven:
   ```
   mvn spring-boot:run
   ```
   The app will be available at:
   http://localhost:8080


### API Documentation
Swagger UI documentation is available at:
http://localhost:8080/swagger-ui/index.html


### API Endpoints
Anime CRUD Endpoints

| Method | URL | Description | Request Body |
|--------------|--------------|--------------|--------------|
| POST | /anime | Add a new anime | JSON
| GET | /anime | Get all anime records | N/A
| GET | /anime/{id} | Get anime by ID | N/A
| PUT | /anime/{id} | Update anime by ID | JSON
| DELETE | /anime/{id} | Delete anime by ID | N/A


### Sample JSON Request Bodies
#### Create Anime (POST /anime)

```
{
  "name": "Attack on Titan",
  "description": "A story of humanity's survival.",
  "score": 9.8
}
```
#### Update Anime (PUT /anime/{id})
```
{
  "name": "Attack on Titan - Final Season",
  "description": "Continuation of humanity's survival.",
  "score": 9.9
}
```

## Author
**Valentin Gobet**

