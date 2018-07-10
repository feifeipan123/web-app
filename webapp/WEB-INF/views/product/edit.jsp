<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑</title>
</head>
<body>
<form action="product?cmd=save" method="post">
    <input type="hidden" name="id" value="${product.id}"/>
    <table border="1" cellpadding="0" cellspacing="0">
         <tr>
             <td>货品名称</td>
             <td>
                 <input type="text" name="productName" value="${product.productName}"/>
             </td>
         </tr>
         <tr>
             <td>货品品牌</td>
             <td>
                 <input type="text" name="brand" value="${product.brand}"/>
             </td>
         </tr>
         <tr>
             <td>供应商</td>
             <td>
                 <input type="text" name="supplier" value="${product.supplier}"/>
             </td>
         </tr>
          <tr>
             <td>零售价</td>
             <td>
                 <input type="number" name="salePrice" value="${product.salePrice}"/>
             </td>
         </tr>
         <tr>
             <td>成本价</td>
             <td>
                 <input type="number" name="costPrice" value="${product.costPrice}"/>
             </td>
         </tr>
         <tr>
             <td>折扣</td>
             <td>
                 <input type="text" name="cutoff" value="${product.cutoff}"/>
             </td>
         </tr>
         <tr>
             <td>货品分类</td>
             <td>
                <select name="dir_id">
	                <c:forEach items="${dirs}" var="d" varStatus="vs">
	                    <option value="${d.id}" ${product.dir_id==d.id?"selected":""}>${d.dirName}</option>
	                </c:forEach>
                </select>
             </td>
         </tr>
         <tr>
	          <td colspan="2">
	            <input type="submit" value="保存"/>
	           </td>
         </tr>
    </table>
</form>
</body>
</html>