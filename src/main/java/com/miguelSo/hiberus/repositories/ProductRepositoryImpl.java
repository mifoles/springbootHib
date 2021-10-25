package com.miguelSo.hiberus.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miguelSo.hiberus.models.ProductModel;

@Repository
@Transactional(readOnly = true)
public class ProductRepositoryImpl implements ProductRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<ProductModel> searcher(String name, String description) {
		System.out.println(entityManager);
		Query qs = entityManager.createNativeQuery("SELECT p.* FROM springdb.product p WHERE p.name = ? or p.description = ?", ProductModel.class);
		qs.setParameter(1, name);
		qs.setParameter(2, description);
		return qs.getResultList();
	}

	
}
