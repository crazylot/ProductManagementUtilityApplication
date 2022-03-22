<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
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
  <div align="center">
 <c:if test="${ProductTobechanged != null}">
<form action="update" method="post" enctype="multipart/form-data">
    <br>
    <label><b>Edit Form</b></label> 
    <input type="hidden" name="id" value="<c:out value="${ProductTobechanged.id}"/>"/><br><br>
    <label>Title</label> 
    <input type="text" id="title" name="title" value ="<c:out value="${ProductTobechanged.title}"/>"><br><br> 
    <label>Quantity</label>  
    <input type="text" id="quantity" name="quantity" value ="<c:out value="${ProductTobechanged.quantity}"/>"><br><br>  
    <label>Size</label> 
    <input type="text" id="size" name="size" value ="<c:out value="${ProductTobechanged.size}"/>"><br><br>
    <label>Image</label>  
    <input type="file" name="image" value ="<c:out value="${ProductTobechanged.imagename}"/>"><br><br>
    <label><button type="submit">Edit Product</button></label>
</form>
</c:if>
</div>
</body>
</html>