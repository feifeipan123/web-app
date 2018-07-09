package com._520it.shopping.dao;

import java.util.List;

import com._520it.shopping.domain.Product;

public interface IProductDAO {
	void save(Product stu);
	void delete(Long id);
	void update(Product newStu);
	Product get(Long i);
	List<Product> listAll();
}
