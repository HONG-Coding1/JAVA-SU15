# JAVA-SU15

Spring Boot REST API project for managing students and products.

## Tech Stack

- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Gradle
- Lombok

## Run Project

```powershell
.\gradlew.bat bootRun
```

## Test Project

```powershell
.\gradlew.bat test
```

## Base URL

```http
http://localhost:8080/api/v2
```

## Student API

### List Students

```http
GET /students?page=1&size=10
```

### Search Students

```http
GET /students?email=test@example.com
GET /students?firstName=John
GET /students?lastName=Doe
```

### Get Student By ID

```http
GET /students/{id}
```

### Create Student

```http
POST /students
```

Request body:

```json
{
  "first_name": "John",
  "last_name": "Doe",
  "email": "john@example.com",
  "phone_number": "012345678",
  "address": "Phnom Penh",
  "password": "password123"
}
```

### Update Student

```http
PUT /students/{id}
```

### Delete Student

```http
DELETE /students/{id}
```

## Product API

### List Products

```http
GET /products?page=1&size=10
```

### Search Products

```http
GET /products?name=Laptop
```

### Get Product By ID

```http
GET /products/{id}
```

### Create Product

```http
POST /products
```

Request body:

```json
{
  "name": "Laptop",
  "description": "A high-performance laptop",
  "price": 999.99
}
```

### Update Product

```http
PUT /products/{id}
```

### Delete Product

```http
DELETE /products/{id}
```

## Notes

- `page` starts from `1`.
- `size` must be greater than `0`.
- Student email search returns `404 Student Not Found` when no matching email exists.
- Get, update, and delete return `404` when the record does not exist.
