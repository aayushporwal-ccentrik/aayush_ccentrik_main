package com.aay5.Entity;




	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;

	@Entity

public class Address {


	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(nullable = false, name = "ID")
	    private Long addressID;

	    @Column(name = "TYPE")
	    private String adressType;

	    @Column(name = "STREET")
	    private String street;

	    @Column(name = "CITY")
	    private String city;

	    @Column(name = "COUNTRY")
	    private String country;

	    @Column(name = "REGION")
	    private String region;

	    public Address() {
	    }

	    public Address(Long addressID, String adressType, String street,
	                   String city, String country, String region) {
	        super();
	        this.addressID = addressID;
	        this.adressType = adressType;
	        this.street = street;
	        this.city = city;
	        this.country = country;
	        this.region = region;
	    }

	    public Long getAddressID() {
	        return addressID;
	    }

	    public void setAddressID(Long addressID) {
	        this.addressID = addressID;
	    }

	    public String getAdressType() {
	        return adressType;
	    }

	    public void setAdressType(String adressType) {
	        this.adressType = adressType;
	    }

	    public String getStreet() {
	        return street;
	    }

	    public void setStreet(String street) {
	        this.street = street;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public String getCountry() {
	        return country;
	    }

	    public void setCountry(String country) {
	        this.country = country;
	    }

	    public String getRegion() {
	        return region;
	    }

	    public void setRegion(String region) {
	        this.region = region;
	    }
	}
