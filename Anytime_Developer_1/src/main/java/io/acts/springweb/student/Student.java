package io.acts.springweb.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity                               //For database connectivity  
//@Table(name="students")               // Table for sql and document for mongodb
public class Student {
	@Id                               // id is primary key thats why we use annotation
	private long id;
	private String name;
	private String email;
	
	@Column(name="phone_No")
	private String phoneNo;

	public Student() {
		super();                       // This is super constructor
		// TODO Auto-generated constructor stub
		
	}

	public long getId() {                             // getter method
		return id;
	}

	public void setId(long id) {                        // setter method 
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Student(long id, String name, String email, String phoneNo) {      // Constructor created using fields
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}
}
