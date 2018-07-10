package com._520it.shopping.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.shopping.dao.IProductDAO;
import com._520it.shopping.dao.impl.ProductDAOImpl;
import com._520it.shopping.domain.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IProductDAO dao;
	public void init() throws ServletException {
	        dao = new ProductDAOImpl();
	}
	 
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    String cmd = req.getParameter("cmd");
	    if("edit".equals(cmd)){
	    	edit(req,resp);
	    }else if("delete".equals(cmd)){
	    	delete(req,resp);
	    }else if("save".equals(cmd)){
	    	saveOrUpdate(req,resp);
	    }else{
	    	list(req,resp);
	    }
	}
	
	//显示商品列表
	protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Product> list = dao.listAll();
		req.setAttribute("products",list);
		req.getRequestDispatcher("WEB-INF/views/product/list.jsp").forward(req,resp);
	}
	
	//删除指定商品
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		dao.delete(Long.valueOf(id));
		resp.sendRedirect("/product");
	}
	
	//进入编辑页面
	protected void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if(hasLength(id)){
			Product p = dao.get(Long.valueOf(id));
			req.setAttribute("product",p);
		}
		req.getRequestDispatcher("WEB-INF/views/product/edit.jsp").forward(req,resp);
	}

	//新增或更新操作
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    Product p = new Product();
	    this.request2Obj(req,p);
	    String id = req.getParameter("id");
	    if(p.getId()!=null){
	    	dao.update(p);
	    }else{
	    	dao.save(p);
	    }
	    resp.sendRedirect("/product");
	}

	private void request2Obj(HttpServletRequest req, Product p) {
		String id = req.getParameter("id");
		String productName = req.getParameter("productName");
		String brand = req.getParameter("brand");
		String supplier = req.getParameter("supplier");
		String salePrice = req.getParameter("salePrice");
		String costPrice = req.getParameter("costPrice");
		String cutoff = req.getParameter("cutoff");
		String dir_id = req.getParameter("dir_id");
		if(hasLength(id)){
			p.setId(Long.valueOf(id));
		}
		p.setProductName(productName);
		p.setBrand(brand);
		p.setSupplier(supplier);
		p.setSalePrice(new BigDecimal(salePrice));
		p.setCostPrice(new BigDecimal(costPrice));
		p.setCutoff(Double.valueOf(cutoff));
		p.setDir_id(Long.valueOf(dir_id));
	}
	
	private boolean hasLength(String str) {
		return str!=null && !"".equals(str.trim());
	}
}
