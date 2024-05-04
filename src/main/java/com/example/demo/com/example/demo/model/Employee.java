package com.example.demo.model;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

@Document
public class Employee {


	@Id
	private String id = UUID.randomUUID().toString();
	

	private String employeeName;
    private String phoneNumber;
    private String email;
    private String reportsTo;
    private String profileImage;

    public Employee() {
    	
    }
    public Employee(String id, String employeeName, String phoneNumber, String email, String reportsTo,
    		String profileImage) {
    	super();
    	this.id = id;
    	this.employeeName = employeeName;
    	this.phoneNumber = phoneNumber;
    	this.email = email;
    	this.reportsTo = reportsTo;
    	this.profileImage = profileImage;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}


