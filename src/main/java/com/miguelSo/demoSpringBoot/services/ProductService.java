package com.miguelSo.demoSpringBoot.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelSo.demoSpringBoot.models.ProductModel;
import com.miguelSo.demoSpringBoot.repositories.ProductRepository;
import com.miguelSo.demoSpringBoot.repositories.ProductRepositoryCustom;
import com.miguelSo.demoSpringBoot.repositories.ProductRepositoryImpl;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductRepositoryImpl productRepositoryCustom;
	
	public ArrayList<ProductModel> listAll(){
		return (ArrayList<ProductModel>) productRepository.findAll();
	}
	
	public Optional<ProductModel> findById(Long id){
		return productRepository.findById(id);
	}
	
	public ArrayList<ProductModel> findByName(String name){
		return productRepository.findByName(name);
	}
	
	public ArrayList<ProductModel> findByDescription(String desc){
		return productRepository.findByDescription(desc);
	}
	
	public ProductModel saveProduct(ProductModel product) {
		return productRepository.save(product);
	}
	
	public boolean deleteProduct(Long id) {
		try {
			productRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public ArrayList<ProductModel> searcher(String name, String description) {
		return (ArrayList<ProductModel>) productRepositoryCustom.searcher(name, description);
	}
	
}
