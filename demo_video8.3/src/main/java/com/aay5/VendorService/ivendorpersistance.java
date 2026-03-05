package com.aay5.VendorService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aay5.Entity.Vendor;

@RepositoryRestResource(collectionResourceRel = "vendor", path = "newVendor")
public interface ivendorpersistance extends JpaRepository<Vendor, Long>{
	
	List <Vendor> findByCompanyName(String companyName);
	
//	@Query(nativeQuery=true, 
//			value= "Select * From public.Vendor where lower(GST_No) like %?1")
	//List<Vendor> lookUPVendorByGST(String GSTNo)
}
