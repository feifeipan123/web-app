package com._520it.shopping.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com._520it.shopping.dao.IProductDirDAO;
import com._520it.shopping.dao.impl.ProductDirDAOImpl;
import com._520it.shopping.domain.Product;
import com._520it.shopping.domain.ProductDir;



public class ProductDirDAOTest {
	private IProductDirDAO dao = new ProductDirDAOImpl();
	@Test
	public void testSave() {
		 ProductDir p = new ProductDir();
		 p.setDirName("鼠标");
		 p.setParent_id(1L);
		 dao.save(p);
	}
	
	@Test
	public void testUpdate() {
		 ProductDir p = dao.get(2L);
		 p.setDirName("无线鼠标");
		 dao.update(p);
	}
	
	@Test
	public void testGet() {
		ProductDir p = dao.get(1L);
		System.out.println(p);
	}
	
	@Test
	public void testListAll() {
		List<ProductDir> list = dao.listAll();
		System.out.println(list);
	}
}
