package com.npci.FinalProject.controller;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.FinalProject.beans.Product;
import com.npci.FinalProject.service.ProductService;

@RestController
@RequestMapping("/productapi")
public class ProductController {
	
	@Autowired
	private ProductService  ps;
	
	@PostMapping(path="/addproducts",consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addProductApi(@RequestBody Product product){
		//@RequestBody takes the JSON and maps to the profile object and initialize all the properties
		Product p = ps.addProduct(product);
		return ResponseEntity.status(201).body(p);
		//201: HHTP response code for CREATE
	}
	
	@GetMapping(path="/getproducts",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE) // produces parameter is optional
	public ResponseEntity<Object> getProductsapi(){
		List<Product> products = ps.getProducts();
		return ResponseEntity.status(200).body(products);
	}
	
	@GetMapping(path="/generatebills",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE) // produces parameter is optional
	public ResponseEntity<Object> generatebills(){
		Map<String,Object> finalmap = ps.generateBills();
		return ResponseEntity.status(200).body(finalmap);
	}
	
	
	
}
