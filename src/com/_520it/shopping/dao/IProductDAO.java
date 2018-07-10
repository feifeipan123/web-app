package com._520it.shopping.dao;

import java.util.List;

import com._520it.shopping.domain.Product;

public interface IProductDAO {
	void save(Product obj);
	void delete(Long id);
	void update(Product obj);
	Product get(Long i);
	List<Product> listAll();
}
