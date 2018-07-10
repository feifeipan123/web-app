package com._520it.shopping.dao.impl;

import java.util.List;

import com._520it.shopping.dao.IProductDirDAO;
import com._520it.shopping.domain.Product;
import com._520it.shopping.domain.ProductDir;
import com._520it.shopping.util.BeanHandler;
import com._520it.shopping.util.BeanListHandler;
import com._520it.shopping.util.JdbcTemplate;

public class ProductDirDAOImpl implements IProductDirDAO{

	public void save(ProductDir obj) {
		 String sql = "insert into productDir(dirName,parent_id) VALUES(?,?)";
		 Object[] params = {
				     obj.getDirName(),obj.getParent_id()
				 };
		 JdbcTemplate.update(sql,params); 
	}

	public void delete(Long id) {
		String sql = "delete from productDir where id=?";
		 JdbcTemplate.update(sql,id); 
	}

	public void update(ProductDir obj) {
		 String sql = "update productDir set dirName=?,parent_id=? where id=?";
		 Object[] params = {
				 obj.getDirName(),obj.getParent_id(),obj.getId()
			 };
	     JdbcTemplate.update(sql,params); 
	}

	public ProductDir get(Long id) {
		 String sql = "select * from productDir where id=?";
		 return JdbcTemplate.query(sql,new BeanHandler<ProductDir>(ProductDir.class),id); 
	}

	public List<ProductDir> listAll() {
		 String sql = "select * from productDir";
		 return JdbcTemplate.query(sql,new BeanListHandler<ProductDir>(ProductDir.class)); 
	}
}
