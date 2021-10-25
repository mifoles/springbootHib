package com.miguelSo.demoSpringBoot.repositories;

import java.util.List;

import com.miguelSo.demoSpringBoot.models.ProductModel;

public interface ProductRepositoryCustom {

	public abstract List<ProductModel> searcher(String name, String description);
	
}
