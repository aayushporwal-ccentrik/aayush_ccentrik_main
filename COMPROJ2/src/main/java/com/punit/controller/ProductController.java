package com.punit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.punit.entities.Product;
import com.punit.services.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService pservice;

    // GET ALL PRODUCTS
    @GetMapping("/product")
    public List<Product> getProduct(){
        return pservice.ReadAllProducts();
    }

    // GET PRODUCT BY ID
    @RequestMapping("/product/{productId}")
    public Product getProductById(@PathVariable("productId") Long code){

        Optional<Product> searchResult = pservice.ReadProductById(code);

        if(!searchResult.isPresent()){
            return new Product((long)0,"","","","","");
        }

        return searchResult.get();
    }

    // CREATE PRODUCT
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product mypostbody){
        return pservice.createProduct(mypostbody);
    }

    // UPDATE PRODUCT
    @RequestMapping(method = RequestMethod.PUT, value = "/product")
    public Product updateProduct(@RequestBody Product product){
        return pservice.changeProduct(product);
    }

    // DELETE PRODUCT
    @RequestMapping(method = RequestMethod.DELETE, value = "/product/{productId}")
    public String deleteProduct(@PathVariable("productId") Long id){
        return pservice.deleteProduct(id);
    }

}