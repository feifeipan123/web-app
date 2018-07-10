package com._520it.shopping.dao;

import java.util.List;

import com._520it.shopping.domain.ProductDir;

public interface IProductDirDAO {
	void save(ProductDir Obj);
	void delete(Long id);
	void update(ProductDir obj);
	ProductDir get(Long i);
	List<ProductDir> listAll();
}
