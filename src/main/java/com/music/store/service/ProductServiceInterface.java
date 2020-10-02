package com.music.store.service;

import java.io.IOException;
import java.util.List;

import com.music.store.model.Product;

public interface ProductServiceInterface {
	
	public List<Product> getProductsLists();

	public Product getProductById(int productId);
	
	public void saveProduct(Product product);
	
	public void deleteById(int theid);

}
