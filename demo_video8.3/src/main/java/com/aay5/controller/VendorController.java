package com.aay5.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.aay5.Entity.Vendor;
import com.aay5.VendorService.VendorService;


@RestController
public class VendorController {

    @Autowired
    VendorService Service;

    // get all entities
    @GetMapping("vendor")
    public List<Vendor> getVendor() {   // worked as internal table having key pair
        return Service.ReadAllvendors();
    }

    // get specific entity
    // @RequestMapping("/vendor/{vendorcode}")
    // public vendor getVendorbyId(@PathVariable("vendorcode") String code) {
    //     return Service.getsinglevendorbyID(code);
    // }

    // create entity
    @PostMapping("vendor")
    public Vendor createVendor(@RequestBody Vendor mypostbody) {
        return Service.createVendor(mypostbody);
    }
    

//
    @GetMapping("/vendor/search")
    public List<Vendor> searchByCompany(@RequestParam String company){
		return Service.searchByCompanyName(company);
}
    // For data edit
    // @PutMapping("/changeVendor")
    // public vendor updateVendor(@RequestBody vendor Vendor) {
    //     return Service.changevendor(Vendor);
    // }
}