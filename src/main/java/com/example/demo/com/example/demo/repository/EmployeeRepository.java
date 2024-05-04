package com.example.demo.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepository  extends CouchbaseRepository<Employee, String>{
	
	Employee findByEmail(String email);
	Employee findByPhoneNumber(String phoneNumber);

}
