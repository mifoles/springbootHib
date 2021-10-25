package com.miguelSo.demoSpringBoot.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miguelSo.demoSpringBoot.models.ProductModel;
import com.miguelSo.demoSpringBoot.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping()
	public ArrayList<ProductModel> listAll() {
		return (ArrayList<ProductModel>)productService.listAll();
	}
	
	@PostMapping()
	public ProductModel save(@RequestBody ProductModel product) {
		return (ProductModel)productService.saveProduct(product);
	}
	
	@GetMapping( path = "/{id}")
	public Optional<ProductModel> findById(@PathVariable("id") Long id){
		return productService.findById(id);
	}
	
	@DeleteMapping( path = "/{id}")
	public String delete(@PathVariable("id") Long id) {

		boolean ok = productService.deleteProduct(id) ;
		if(ok) {
			return "Producto eliminado. id:"+id;
		}else {
			return "No se pudo eliminar el producto con id"+id;
		}
		
			
	}
	
	@GetMapping("/searchBy/name")
	public ArrayList<ProductModel> findByName(@RequestParam("name") String name){
		return this.productService.findByName(name);
	}
	
	@GetMapping("/searchBy/description")
	public ArrayList<ProductModel> findByDescription(@RequestParam("description") String desc){
		return productService.findByDescription(desc);
	}
	
	 @GetMapping("/query")
    public ArrayList<ProductModel> searcher(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "description", required = false)String description){
        return this.productService.searcher(name, description);
    }
	

}
