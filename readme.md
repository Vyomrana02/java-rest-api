# Employee Management System

This project is an Employee Management System with RESTful API endpoints implemented using Spring Boot. It allows users to perform various operations such as adding, retrieving, updating, and deleting employees from a database.

## Requirements

- Java 8 or higher
- Maven
- Spring Boot
- Couchbase NOSQL Server (for database storage)

## Installation

1. Clone the repository:

```
git clone https://github.com/yourusername/employee-management-system.git
```

2. Clean the Maven Application

3. Rebuild the Maven Application

4. Run as SpringBOOT App.


   
## API Endpoints

### Entry Level

#### a. Add Employee

- **POST (http://localhost:8085/user/api/v1/createEmp)**
- Request Body:

```
{
    "employeeName": "Suresh",
    "phoneNumber": "999999999",
    "email": "vyom.rana206@gmail.com",
    "reportsTo":"",
    "profileImage": "https://www.istockphoto.com/photo/middle-eastern-lady-using-laptop-working-online-sitting-in-office-gm1434212178-475903282?utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fimages%2Fsearch%2Fuser%2F&utm_term=user"
}
```


- **POST (http://localhost:8085/user/api/v1/createEmp)**
- Request Body:

```
{
    "employeeName": "Ramesh",
    "phoneNumber": "8888888888",
    "email": "ncs0free@gmail.com",
    "reportsTo":"d758ee93-90b7-44e3-a070-8daf13afb8c7",
    "profileImage": "https://www.istockphoto.com/en/search/2/image?mediatype=&phrase=user&utm_source=pixabay&utm_medium=affiliate&utm_campaign=SRP_image_sponsored&utm_content=https%3A%2F%2Fpixabay.com%2Fimages%2Fsearch%2Fuser%2F&utm_term=user"
}

```


- **POST (http://localhost:8085/user/api/v1/createEmp)**
- Request Body:

```
{
    "employeeName": "Vyom",
    "phoneNumber": "7777777777",
    "email": "vyom.rana02@gmail.com",
    "reportsTo":"e690d753-999a-4465-8770-3b08057b8576",
    "profileImage": "https://pixabay.com/photos/photographer-girl-photography-5149664/"
}
```

#### b. Get All Employee
- **GET (http://localhost:8085/user/api/v1/allEmployees)**


#### c. Delete Employee
- **DELETE (http://localhost:8085/user/api/v1/deleteEmployeeById/<Emp-id>)**

#### d. Update Employee
- **PUT (http://localhost:8085/user/api/v1/updateEmployee)**
- Request Body:
```
{
        "id": "87bde10a-c3ea-43ac-8ecb-0e320d41b4cd",
        "employeeName": "Vyom Rana",
        "phoneNumber": "7777777777",
        "email": "vyom.rana02@gmail.com",
        "reportsTo": "e690d753-999a-4465-8770-3b08057b8576",
        "profileImage": "https://pixabay.com/photos/photographer-girl-photography-5149664/"
}
```
  
### Intermediate Level

#### a. Get nth Level Manager of an Employee
- **GET(http://localhost:8085/user/api/v1/getnlevel/<Emp-id>/<level>)**


#### b.Get Employees with Pagination and Sorting
- **GET(http://localhost:8085/user/api/v1/allEmployeesByEmail?page=1&size=2)**
- **GET(http://localhost:8085/user/api/v1/allEmployeesByName?page=1&size=2)**
