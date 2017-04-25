package com.lili.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lili.domains.Product;
import com.lili.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public void	setProductRepository (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public Iterable<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {		
		return productRepository.findOne(id);
	}
	
	@Override
	public Product deleteProduct(Product product) {
		productRepository.delete(product);
		return null;
	}

	@Override
	public Product saveProduct(Product product) {		
		return productRepository.save(product);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);		
	}
	
}
