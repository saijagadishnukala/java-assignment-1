package com.npci.FinalProject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.npci.FinalProject.beans.Product;

@Service
public class ProductServiceImpl implements ProductService {
	public static List<Product> plist = new ArrayList<>();
	

	@Override
	public Product addProduct(Product productdtls) {
		// TODO Auto-generated method stub
		plist.add(productdtls);
		return productdtls;
		
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return plist;
	}

	@Override
	public Map<String, Object> generateBills() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Products",plist);
		int sum=0;
		for(Product p: plist) {
			sum+=p.getPrice()*p.getPquantity() ;
		}
		map.put("Total Price", sum);
		
		return map;
	}
	

}
