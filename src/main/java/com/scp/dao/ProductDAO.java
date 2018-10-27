package com.scp.dao;

import java.util.List;

import com.scp.entities.ProductEntity;

public interface ProductDAO {
	public ProductEntity addProduct(ProductEntity product);
	public ProductEntity getProduct(int productId);
	public boolean deleteProduct(int productId);
	public ProductEntity updateProduct(ProductEntity product);
	public List<ProductEntity> getAllProducts();
}
