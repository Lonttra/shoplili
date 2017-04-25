package com.lili.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.lili.domains.Product;

public interface ProductService {

		Iterable<Product> listAllProducts();
		
		Product getProductById(Integer id);		

		Product deleteProduct(Product product); 
		
		Product saveProduct(Product product);
		
		Page<Product> findAll(Pageable pageable);
		
}
