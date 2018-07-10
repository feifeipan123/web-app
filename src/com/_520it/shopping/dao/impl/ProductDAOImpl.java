package com._520it.shopping.dao.impl;

import java.util.List;

import com._520it.shopping.dao.IProductDAO;
import com._520it.shopping.domain.Product;
import com._520it.shopping.util.BeanHandler;
import com._520it.shopping.util.BeanListHandler;
import com._520it.shopping.util.JdbcTemplate;

public class ProductDAOImpl implements IProductDAO{

	public void save(Product obj) {
		 String sql = "insert into product(productName,brand,supplier,"
	     	 		+ "salePrice,costPrice,cutoff,dir_id) VALUES(?,?,?,?,?,?,?)";
		 Object[] params = {
				     obj.getProductName(),obj.getBrand(),
				     obj.getSupplier(),obj.getSalePrice(),
				     obj.getCostPrice(),obj.getCutoff(),
				     obj.getDir_id()
				 };
		 JdbcTemplate.update(sql,params); 
	}

	public void delete(Long id) {
		String sql = "delete from product where id=?";
		 JdbcTemplate.update(sql,id); 
	}

	public void update(Product obj) {
		 String sql = "update product set productName=?,brand=?,supplier=?,"
	    	 		+ "salePrice=?,costPrice=?,cutoff=?,dir_id=? where id=?";
		 Object[] params = {
			     obj.getProductName(),obj.getBrand(),
			     obj.getSupplier(),obj.getSalePrice(),
			     obj.getCostPrice(),obj.getCutoff(),
			     obj.getDir_id(),obj.getId()
			 };
	     JdbcTemplate.update(sql,params); 
	}

	public Product get(Long id) {
		 String sql = "select * from product where id=?";
		 return JdbcTemplate.query(sql,new BeanHandler<Product>(Product.class),id); 
	}

	public List<Product> listAll() {
		 String sql = "select * from product";
		 return JdbcTemplate.query(sql,new BeanListHandler<Product>(Product.class)); 
	}
}
