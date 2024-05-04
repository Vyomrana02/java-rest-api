package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Autowired
	private EmailService emailService;
	
	public Object createEmployee(Employee reqData) {
			
		if(employeeRepository.findByPhoneNumber(reqData.getPhoneNumber())!= null) {
			return null;
		} else if(employeeRepository.findByEmail(reqData.getEmail())!= null) {
			return null;
		}
		if(reqData.getReportsTo() == "") {
			return employeeRepository.save(reqData);
		}
		String message =  reqData.getEmployeeName() + " will now work under you. Mobile number is "+reqData.getPhoneNumber() +" and email is "+reqData.getEmail();
		String toEmail = employeeRepository.findById(reqData.getReportsTo()).get().getEmail();
		emailService.sendSimpleEmail(toEmail,"New Employee!!",message);
		return employeeRepository.save(reqData);
	}
	
	public Object getAllEmployees() {
		return employeeRepository.findAll();
	}
	public Optional<Employee> findEmployeeById(String id) {
		return employeeRepository.findById(id);
	}

	public Object getEmployeeById(String id) {
		return employeeRepository.findById(id);
	}

	public Object updateEmployee(Employee reqData, Employee isData) {
		isData.setEmployeeName(reqData.getEmployeeName());
		isData.setEmail(reqData.getEmail());
		isData.setPhoneNumber(reqData.getPhoneNumber());
		isData.setProfileImage(reqData.getProfileImage());
		isData.setReportsTo(reqData.getReportsTo());
		return employeeRepository.save(isData);
	}
	public Object deleteEmployeeById(String id) {
		employeeRepository.deleteById(id);
		return null;
	}
	
	public Optional<Employee> getNLevelManager(String id,int level) {
		if(level <= 0) {
			return null; 
		}
		Optional<Employee> emp = employeeRepository.findById(id);
		Optional<Employee> manager = employeeRepository.findById(emp.get().getReportsTo());

		while(level > 1) {
			level--;
			manager = employeeRepository.findById(manager.get().getReportsTo());
			if(manager.get().getReportsTo() == "" && level>1)
				return null;
		}
		return manager;
	}
	
	public Object getAllEmployeeByEmail(int page,int size) {
		Pageable paging = PageRequest.of(
	            page-1, size, Sort.by("email").ascending());
	        Page<Employee> page1 = employeeRepository.findAll(paging);
	 
	        // Retrieve the items
	        return page1.getContent();
	}
	
	public Object getAllEmployeeByName(int page,int size) {
		Pageable paging = PageRequest.of(
	            page-1, size, Sort.by("employeeName").ascending());
	        Page<Employee> page1 = employeeRepository.findAll(paging);
	 
	        // Retrieve the items
	        return page1.getContent();
	}
	
}

