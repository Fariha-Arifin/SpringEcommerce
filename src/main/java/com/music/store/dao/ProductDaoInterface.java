package com.music.store.dao;


import java.io.IOException;
import java.util.List;

import com.music.store.model.Product;

public interface ProductDaoInterface {
	
	public List<Product> getProductsList();
	
	public void saveProduct(Product product);
	
	public Product getProductById(int productId);
	
	public void deleteById(int theid);

	//public Product getProductById(int productId) throws IOException;

}
