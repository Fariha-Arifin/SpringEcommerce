package com.music.store.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.store.dao.ProductDaoInterface;
import com.music.store.model.Product;

@Service
public class ProductService implements ProductServiceInterface {
	
	@Autowired
	private ProductDaoInterface productDao;

	
	@Override
	@Transactional
	public List<Product> getProductsLists() {
		
		return productDao.getProductsList();
	}

	@Override
	@Transactional
	public Product getProductById(int productId){
		
		return productDao.getProductById(productId);
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		productDao.saveProduct(product);
		
	}

	@Override
	@Transactional
	public void deleteById(int theid) {
		productDao.deleteById(theid);
		
	}

}
