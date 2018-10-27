package com.scp.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.scp.bean.Product;
import com.scp.service.ProductService;
import com.scp.service.impl.ProductServiceImpl;

@Path("/products")
public class ProductController {

	ProductService pService = new ProductServiceImpl();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Product getProduct(@PathParam("id") int id){
		return  pService.getProduct(id);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
    @Consumes(MediaType.APPLICATION_JSON)
	public List<Product> getAllProductInfo(){
		return pService.getAllProducts();
	}
	
	
	@DELETE
    @Produces(MediaType.TEXT_PLAIN)//convert list<country> java object to json country obj
	@Path("/{id}")
	public boolean deleteProduct(@PathParam("id") int id){
		return pService.deleteProduct(id);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
	public Product updateProductInfo(Product product){
		return pService.updateProduct(product);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
	@Consumes(MediaType.APPLICATION_JSON)//convert list<country> java object to json country obj
	public Product addProductInfo(Product product){
		return pService.addProduct(product);
	}
	
	
	
}
