package com.miguelSo.hiberus.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miguelSo.hiberus.models.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long>, ProductRepositoryCustom{

	public abstract ArrayList<ProductModel> findByName(String name);
	public abstract ArrayList<ProductModel> findByDescription(String description);
	
	
}
