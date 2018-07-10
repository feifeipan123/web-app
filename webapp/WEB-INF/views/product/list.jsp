<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<a href="/product?cmd=edit">添加</a>
 <table border="1" width="80%" cellpadding="0" cellspacing="0">
       <tr style="background-color:orange">
	       <th>货品编号</th>
	       <th>货品名称</th>
	       <th>货品品牌</th>
	       <th>货品分类</th>
	       <th>供应商</th>
	       <th>零售价</th>
	       <th>成本价</th>
	       <th>折扣</th>
	       <th>操作</th>
       </tr>
       <c:forEach items="${products}" var="s" varStatus="vs">
	       <tr style='background-color:${vs.count%2==0?"gray":""}'>
	           <td>${s.id}</td>
	           <td>${s.productName}</td>
	           <td>${s.brand}</td>
	           
	           <td>${s.dir_id}</td>
	           <td>${s.supplier}</td>
	           <td>${s.salePrice}</td>
	           
	           <td>${s.costPrice}</td>
	           <td>${s.cutoff}</td>
	           <td>
	              <a href="/product?cmd=edit&id=${s.id}">编辑</a>
	              <a href="/product?cmd=delete&id=${s.id}">删除</a>
	           </td>
	       </tr>
       </c:forEach>
       
   </table>

</body>
</html>