<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><body bgcolor="white">
        <%
            session.invalidate();
        %>
        <h1><font color="Red">You are Sucessfully logged out...</font></h1>
        <a href="login.jsp">Go-Back To Login Page</a>
    </body>
</html>