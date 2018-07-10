package com._520it.shopping.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com._520it.shopping.dao.IProductDAO;
import com._520it.shopping.dao.impl.ProductDAOImpl;
import com._520it.shopping.domain.Product;

public class ProductDAOTest {
	private IProductDAO productDAO = new ProductDAOImpl();

	@Test
	public void testSave() {
		Product p = new Product();
		 p.setProductName("电脑123");
		 p.setBrand("苹果");
		 p.setSupplier("pppp");
		 p.setSalePrice(new BigDecimal(500));
		 p.setCostPrice(new BigDecimal(100.8));
		 p.setCutoff(0.7);
		 p.setDir_id(1234L);
		productDAO.save(p);
	}

	@Test
	public void testDelete() {
		productDAO.delete(2l);
	}

	@Test
	public void testUpdate() {
		Product p = productDAO.get(4L);
		 p.setProductName("电脑123");
		 p.setBrand("pc");
		 productDAO.update(p);
	}

	@Test
	public void testGet() {
		Product p = productDAO.get(1L);
		System.out.println(p);
	}

	@Test
	public void testListAll() {
		List<Product> list = productDAO.listAll();
		System.out.println(list);
	}
}
