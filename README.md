## Spring Boot REST API with In-Memory Security
This project demonstrates a Spring Boot REST API secured using Spring Security with In-Memory Authentication.
It includes role-based access control (RBAC) for endpoints related to employee management.

## In-Memory User Authentication


| Username | Password  | Roles                    |
| -------- | --------- | ------------------------ |

| ram      | ram@123   | EMPLOYEE                 |

| siya     | siya@123  | EMPLOYEE, MANAGER        |

| krish    | krish@123 | EMPLOYEE, MANAGER, ADMIN |

## Role-Based Endpoint Access

Allowed Access by HTTP Method

| HTTP Method | Endpoint            | Required Role |
| ----------- | ------------------- | ------------- |

| GET         | `/api/employees`    | EMPLOYEE      |

| POST        | `/api/employees`    | MANAGER       |

| PUT         | `/api/employees/**` | MANAGER       |

| DELETE      | `/api/employees/**` | ADMIN         |

## How to Run the Project

Clone the Repository
Build and Run

## Testing the API (Postman / Browser)
GET request (EMPLOYEE allowed)
GET /api/employees

POST request (MANAGER allowed)
POST /api/employees

DELETE request (ADMIN allowed)
DELETE /api/employees/1

## Author

Lavanya Jalla
