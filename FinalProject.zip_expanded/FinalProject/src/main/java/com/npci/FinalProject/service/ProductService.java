package com.npci.FinalProject.service;

import com.npci.FinalProject.beans.Product;
import java.util.*;

public interface ProductService {
	public Product addProduct(Product product);
	
	public List<Product> getProducts();
	
	public Map<String,Object> generateBills();
	
	
	
}
