package com.scp.service;

import java.util.List;

import com.scp.bean.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public Product getProduct(int productId);
	public boolean deleteProduct(int productId);
	public Product updateProduct(Product product);
	public List<Product> getAllProducts();
	
}
