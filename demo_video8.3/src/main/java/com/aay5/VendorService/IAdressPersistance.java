package com.aay5.VendorService;



import org.springframework.data.jpa.repository.JpaRepository;

import com.aay5.Entity.Address;


public interface IAdressPersistance extends JpaRepository<Address, Long>{



}
