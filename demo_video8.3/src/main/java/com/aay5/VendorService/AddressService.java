package com.aay5.VendorService;




	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;

	import com.aay5.Entity.Address;

	@Component
	public class AddressService {

	    @Autowired
	    IAdressPersistance iap;

	    public List<Address> getAddress() {
	        return iap.findAll();
	    }

	    public Address createAddress(Address payload) {
	        return iap.save(payload);
	    }

	    public AddressService() {
	    }
	}
