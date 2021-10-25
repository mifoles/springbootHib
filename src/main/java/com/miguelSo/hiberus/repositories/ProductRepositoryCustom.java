package com.miguelSo.hiberus.repositories;

import java.util.List;

import com.miguelSo.hiberus.models.ProductModel;

public interface ProductRepositoryCustom {

	public abstract List<ProductModel> searcher(String name, String description);
	
}
