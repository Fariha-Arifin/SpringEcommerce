package com.music.store.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.music.store.model.Product;
import com.music.store.service.ProductServiceInterface;

@Controller
public class AdminController {
	
	private Path path;
	//private ResourceLoader resourceLoader;
	
	@Autowired
	ProductServiceInterface productService;
	
	@RequestMapping("/admin")
	public String adminpage()
	{
		
		return "admin";
	}
	
	@RequestMapping("/admin/productInventory")
	public String adminProductInventory(Model themodel)
	{
		List<Product> productList = productService.getProductsLists();
		
		themodel.addAttribute("products",productList);
		
		return "productInventory";
		
	}
	
	@GetMapping("/admin/productInventory/addProduct")
	public String addProduct(Model theModel) {
		
		Product theProduct = new Product();
		
		theModel.addAttribute("product",theProduct);
		
		return "addProduct";
			
	}
	
	@PostMapping("/admin/productInventory/saveProduct")
	public String saveProduct(@Valid @ModelAttribute("product")Product theproduct, BindingResult result,
			HttpServletRequest request)
	{
		
		if(result.hasErrors())
		{
			return "addProduct";
		}
		
		productService.saveProduct(theproduct);
		
		//Resource resource = resourceLoader.getResource("file:webapp/resources/images");
		
		MultipartFile productImageId = theproduct.getImageId();
		//String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get("D:\\eclipse-workspace\\MusicStorehibernateXMLconfigFullWeb\\src\\main\\webapp\\WEB-INF\\resources\\images\\" + theproduct.getProductId() + ".png");
		
		try {
			if(productImageId != null && !productImageId.isEmpty())
			{
				productImageId.transferTo(new File(path.toString()));
				//productImageId.transferTo(resourceLoader.getResource("resources/images/"+theproduct.getImageId()+".png").getFile());
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/admin/productInventory/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId)
	{
		productService.deleteById(productId);
		
		path = Paths.get("D:\\eclipse-workspace\\MusicStorehibernateXMLconfigFullWeb\\src\\main\\webapp\\WEB-INF\\resources\\images\\" + productId + ".png");
		
		if(Files.exists(path))
		{
			try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:/admin/productInventory";
	}
	
	@GetMapping("/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable int productId, Model theModel) {
		
		Product theProduct = productService.getProductById(productId);
		
		theModel.addAttribute("product",theProduct);
			
		return "addProduct";
			
	}

}
