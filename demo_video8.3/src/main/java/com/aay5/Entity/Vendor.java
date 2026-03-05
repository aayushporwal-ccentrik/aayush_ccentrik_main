package com.aay5.Entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

//@Entity tells that vendor is now a table not a class.
@Entity
// We name the table @table  
@Table(name = "VENDOR")
public class Vendor {

	//We want to use this field as PK so we give it id annotation to separate it from rest
    @Id
    // This field an't be null
    @Column(nullable = false, name = "ID")
    //Auto generate automatically generate Id since the type is long it will generate numbers
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false, name = "COMPANY_NAME")
    public String companyName;

    @Column(nullable = false, name = "FIRST_NAME")
    public String firstName;

    @Column(nullable = false, name = "LAST_NAME")
    public String lastName;

    @Column(nullable = false, name = "WEBSITE")
    public String website;

    @Column(nullable = false, name = "EMAIL")
    public String email;

    @Column(nullable = false, name = "STATUS")
    public String status;
    
    @Column(nullable = false, name = "GST_NO")
    public String gstNo;
    
    //We use Fetch type lazy bcoz it we want fetching on  demand
    //Cascade allows the crud operation for address table be possible along the vendor
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    
    @JoinColumn(name="vendor", referencedColumnName = "Id")
    //Creating an association with table address in vendor 
    //address is array of Object, Address is an object of Address class
        private List<Address> addresses = new ArrayList<>();
    
    
   //Empty Constructor 
    public Vendor() {
    	
    }
    
    
//Constructor Using Field 
	public Vendor(Long id, String companyName, String firstName, String lastName, String website, String email,
			String status, String gstNo) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.website = website;
		this.email = email;
		this.status = status;
		this.gstNo = gstNo;
	}

	
	//Getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

  
}