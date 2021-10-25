package com.miguelSo.demoSpringBoot.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miguelSo.demoSpringBoot.models.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long>, ProductRepositoryCustom{

	public abstract ArrayList<ProductModel> findByName(String name);
	public abstract ArrayList<ProductModel> findByDescription(String description);
	
	
}
