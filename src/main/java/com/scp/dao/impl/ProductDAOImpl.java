package com.scp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.dao.ProductDAO;
import com.scp.entities.ProductEntity;
import com.scp.util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO{
	SessionFactory sessionFactory;
	Session session;
	Transaction tr;
	@Override
	public ProductEntity addProduct(ProductEntity product) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		tr = session.beginTransaction();
		session.save(product);
		HibernateUtil.resourceCleanup(session, tr);
		return product;
	}

	@Override
	public ProductEntity getProduct(int productId) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		ProductEntity entity = (ProductEntity) session.get(ProductEntity.class, productId);
		HibernateUtil.resourceCleanup(session, tr);
		return entity;
	}

	@Override
	public boolean deleteProduct(int productId) {
		ProductEntity p= this.getProduct(productId);
		if(p!=null){
			sessionFactory=HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
			session.delete(p);
			HibernateUtil.resourceCleanup(session, tr);	
			return true;
		}
		else
			return false;	
	}
	
	@Override
	public ProductEntity updateProduct(ProductEntity product) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		tr = session.beginTransaction();
		session.merge(product);
		
		HibernateUtil.resourceCleanup(session, tr);
		return product;
	}
	
	@Override
	public List<ProductEntity> getAllProducts() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		List<ProductEntity> productEntities = session.createCriteria(ProductEntity.class).list();
		System.out.println(productEntities);
		HibernateUtil.resourceCleanup(session, tr);
		return productEntities;
	}

}
