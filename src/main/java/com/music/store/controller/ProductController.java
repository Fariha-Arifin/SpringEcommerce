package com.music.store.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.music.store.model.Product;
import com.music.store.service.ProductServiceInterface;

@Controller
public class ProductController {
	
	@Autowired
	ProductServiceInterface productService;
	
	@RequestMapping("/")
	public String showpage()
	{
		
		return "hello";
	}
	
	@RequestMapping("/productList")
	public String getProducts(Model model)
	{
		List<Product> productList = productService.getProductsLists();

		model.addAttribute("products", productList);
		
		//Product product = productList.get(0);
		//model.addAttribute(product);
		
		
		return "list-product";
	}
	
	@RequestMapping("/productList/viewProduct/{productId}")
	public String showviewProduct(@PathVariable int productId, Model model) throws IOException
	{
		Product product = productService.getProductById(productId);
		
		model.addAttribute(product);
		
		return "viewProduct";
	}
	

}
