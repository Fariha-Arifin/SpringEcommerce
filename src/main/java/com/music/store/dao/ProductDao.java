package com.music.store.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.music.store.model.Product;

@Repository
public class ProductDao implements ProductDaoInterface {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Product> getProductsList() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);
		
		List<Product> theProducts = theQuery.getResultList();
		
		return theProducts;
	}


	@Override
	public void saveProduct(Product product) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(product);
		
	}


	@Override
	public Product getProductById(int productId){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Product theProduct = currentSession.get(Product.class, productId);
		
		return theProduct;
	}


	@Override
	public void deleteById(int theid) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query thequery = currentSession.createQuery("delete from Product where id=:pId");
		
		thequery.setParameter("pId",theid);
		
		thequery.executeUpdate();
		
	}


//	@Override
//	public Product getProductById(int productId) throws IOException {
//		
//		for(Product product : getProductsList())
//		{
//			if(product.getProductId() == (productId))
//			{
//				return product;
//			}
//			
//		}
//		
//		throw new IOException("Product not found");
//		
//	}

	
}
