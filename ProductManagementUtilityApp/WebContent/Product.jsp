<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
 <%String username = (String)request.getAttribute("username"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management Page</title>
<style>  
@charset "ISO-8859-1";
table, th, td {  
  border: 1px solid black;  
  border-collapse: collapse;  
}  
th{
  padding-right: 70px;
  padding-left:70px;
  padding-bottom:2px;
  padding-top:2px;
}
td {  
  padding-right:70px;
  padding-left:70px;
  padding-bottom:30px;
  padding-top:30px;
  }
 label{     
  cursor: pointer;
  display: inline-block;
  padding: 3px 6px;
  text-align: right;
  width: 150px;
  vertical-align: top;
  }
</style>  
</head>
<body>
<div id="header">
<h2><center><a href="list">Product Management Tool</a></center></h2>
</div>
<div align="right">
<!--Hi,<%=username%>-->
Hi,<c:out value="${username}"></c:out>
<form method="link" action="logout.jsp">
<input type="submit" value="Logout">
</form>
</div>
<br>
<br>
<form action="insert" method="post" enctype="multipart/form-data">
    <b>&emsp;&emsp;&emsp;&emsp;&emsp;Please enter the product detail to add to stock</b><br>
    <br>
    <label>Title</label> 
    <input type="text" id="title" name="title"><br> 
   <label>Quantity</label>  
    <input type="text" id="quantity" name="quantity"><br>
   <label>Size</label> 
    <input type="text" id="size" name="size"><br>
    <label>Image</label>  
    <input type="file" name="image"><br>
    <input type="hidden" name="username" value="<%=username%>">
  <label><button type="submit" class="btn btn-primary">Add Product</button></label>
</form>
<br>
<br>
<br>
<div align="center">
<table>
            <tr>
                <th>SNo</th>
                <th>Title</th>
                <th>Quantity</th>
                <th>Size</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
            <c:forEach var ="product" items="${allproducts}">
            <tr>
            <td>
            <c:out value="${product.id}"></c:out>
            </td>
            <td>
            <c:out value="${product.title}"></c:out>
            </td>
            <td>
            <c:out value="${product.quantity}"></c:out>
            </td>
            <td>
            <c:out value="${product.size}"></c:out>
            </td>
            <td>
            <img src="data:image/png;base64,${product.imagename}" height="100px" width="100px">
            <!--<c:out value="${product.image}"></c:out> -->
            </td>
             <td><a href="edit?id=<c:out value='${product.id}' />">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
        href="delete?id=<c:out value='${product.id}' />">Delete</a></td>
            </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>