package com.lili.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lili.domains.Product;

public interface ProductRepository extends CrudRepository <Product, Integer>{
	Page<Product> findAll(Pageable pageable);
}
