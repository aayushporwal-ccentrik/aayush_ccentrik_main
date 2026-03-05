package com.aay5.controller;




	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.aay5.Entity.Address;
	import com.aay5.VendorService.AddressService;

	@RestController
	public class AddressController {

	    @Autowired
	    AddressService addsrv;

	    @RequestMapping("/addresses")
	    public List<Address> showAllAddress() {
	        return addsrv.getAddress();
	    }

	    @PostMapping("/addresses")
	    public Address createAddress(@RequestBody Address payload) {
	        return addsrv.createAddress(payload);
	    }

	    public AddressController() {
	        // TODO Auto-generated constructor stub
	    }
	}
