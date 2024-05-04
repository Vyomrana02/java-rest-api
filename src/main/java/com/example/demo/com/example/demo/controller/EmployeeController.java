package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ResultDTO;
import com.example.demo.model.Employee;
import com.example.demo.service.EmailService;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/createEmp")
	public ResponseEntity<?> createEmployee(@RequestBody Employee reqData) {
		ResultDTO<?> responsePacket = null;
		try {
			Employee emp = (Employee)employeeService.createEmployee(reqData);
			if(emp == null) {
				responsePacket = new ResultDTO<>(emp,"User is with same phoneNumber or Email already present", false);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(emp,emp.getId(), true);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);				
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/allEmployees")
	public ResponseEntity<?> allEmployee() {
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(employeeService.getAllEmployees(), "Employee fetched successfully !!", true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") String id) {
		
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(employeeService.deleteEmployeeById(id), "Employee deleted successfully !!", true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee reqData) {
		ResultDTO<?> responsePacket = null;
		try {
			Optional<Employee> isData = employeeService.findEmployeeById(reqData.getId());
			if (isData.isPresent()) {
				responsePacket = new ResultDTO<>(employeeService.updateEmployee(reqData, isData.get()),
						"User Updated Successfully", true);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>("Record not exist", false);
				return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getnlevel/{id}/{level}")
	public ResponseEntity<?> getNLevelManager(@PathVariable("id") String id,
			@PathVariable("level") int level) {
		ResultDTO<?> responsePacket = null;
		try {
			Optional<Employee> emp = employeeService.getNLevelManager(id,level);
			if(emp == null) {
				responsePacket = new ResultDTO<>(null, "Level Entered is more or employee id is not present", true);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(emp.get(), "Manager fetched successfully !!", true);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);				
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/allEmployeesByEmail")
	public ResponseEntity<?> getallEmployeeByEmail(@RequestParam int page, @RequestParam int size) {
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(employeeService.getAllEmployeeByEmail(page,size), "Employee fetched successfully !!", true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/allEmployeesByName")
	public ResponseEntity<?> getallEmployeeByName(@RequestParam int page, @RequestParam int size) {
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(employeeService.getAllEmployeeByName(page,size), "Employee fetched successfully !!", true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
}
