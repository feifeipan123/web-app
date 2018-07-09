package com._520it.shopping.web.servlet;

import java.io.IOException;
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
	
	}
	
	//进入编辑页面
	protected void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	}
	
	//新增或更新操作
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	}
}
