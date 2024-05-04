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

![Screenshot 2024-05-04 112646](https://github.com/Vyomrana02/java-rest-api/assets/87069619/453279c9-2d62-4e7d-80c0-67f45a172454)


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

![Screenshot 2024-05-04 113016](https://github.com/Vyomrana02/java-rest-api/assets/87069619/6e526dce-1140-4e53-a85a-84dd614ef789)


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

![Screenshot 2024-05-04 113213](https://github.com/Vyomrana02/java-rest-api/assets/87069619/2ee2719b-afd5-4320-98ee-5f7cc20b55ae)


#### b. Get All Employee
- **GET (http://localhost:8085/user/api/v1/allEmployees)**

![Screenshot 2024-05-04 113351](https://github.com/Vyomrana02/java-rest-api/assets/87069619/a882f21b-cff7-4ab0-82f2-19950170caf3)


#### c. Delete Employee
- **DELETE (http://localhost:8085/user/api/v1/deleteEmployeeById/{Emp-id})**

![Screenshot 2024-05-04 113439](https://github.com/Vyomrana02/java-rest-api/assets/87069619/5b0af922-8506-4630-92a4-9f80fa52e40f)


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

![Screenshot 2024-05-04 113558](https://github.com/Vyomrana02/java-rest-api/assets/87069619/553ddd3b-3b76-45ef-9ccd-e4b5beedebd3)


### Intermediate Level

#### a. Get nth Level Manager of an Employee
- **GET(http://localhost:8085/user/api/v1/getnlevel/{Emp-id}/{level})**

![Screenshot 2024-05-04 113705](https://github.com/Vyomrana02/java-rest-api/assets/87069619/3ca7ccfa-3020-472b-b732-a3df1e37cfc0)

![Screenshot 2024-05-04 115912](https://github.com/Vyomrana02/java-rest-api/assets/87069619/1f965b41-a4ef-49cc-bc50-49965416fea0)

##### If Level not present or Employee ID is wrong.

![Screenshot 2024-05-04 115938](https://github.com/Vyomrana02/java-rest-api/assets/87069619/e2cb53bd-47e4-473d-a828-6aa7e039fc8a)


#### b. Get Employees with Pagination and Sorting
- **GET(http://localhost:8085/user/api/v1/allEmployeesByEmail?page=1&size=2)**

![Screenshot 2024-05-04 120031](https://github.com/Vyomrana02/java-rest-api/assets/87069619/2c92b5f5-0b91-4f91-aa9f-7bb9d7c739e0)

![Screenshot 2024-05-04 120110](https://github.com/Vyomrana02/java-rest-api/assets/87069619/44fa3a40-8687-49fa-987c-8cef82a0463f)

  
- **GET(http://localhost:8085/user/api/v1/allEmployeesByName?page=1&size=2)**

![Screenshot 2024-05-04 120136](https://github.com/Vyomrana02/java-rest-api/assets/87069619/f25b3cc7-50e1-4a41-b319-59bc1f91668b)


### Advanced Level

#### a.Send Email to Level 1 Manager on New Employee Addition
   - Email will be sent automatically when a new employee is added.
     
![Screenshot 2024-05-04 113243](https://github.com/Vyomrana02/java-rest-api/assets/87069619/0d95f906-2595-4d48-98d4-b831e11bb758)

![Screenshot 2024-05-04 113259](https://github.com/Vyomrana02/java-rest-api/assets/87069619/63f84db3-5b26-4446-b827-57b0df9c3c12)

### Contributing
#### Contributions are welcome! Please feel free to submit a pull request.

### License
#### This project is licensed under the MIT License - see the LICENSE file for details.
