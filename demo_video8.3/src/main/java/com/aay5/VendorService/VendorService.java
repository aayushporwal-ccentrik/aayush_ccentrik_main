package com.aay5.VendorService;

import com.aay5.Entity.Vendor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class VendorService {

    @Autowired
    ivendorpersistance vendor;

    public List<Vendor> ReadAllvendors() {
        return vendor.findAll();
    }

    public Vendor createVendor(Vendor vendorobj) {
        return vendor.save(vendorobj);
    }
    
    public List<Vendor> searchByCompanyName(String companyName){
    		return vendor.findByCompanyName(companyName);
    }
}