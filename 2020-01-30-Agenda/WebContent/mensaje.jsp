<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="e1" class="app.modelo.Empleado" scope="request"> </jsp:useBean>
	Nombre:  <jsp:getProperty property="nombre" name="e1"/><br>
	Num DNI: <jsp:getProperty property="numdni" name="e1"/><br>
<br>
<%=request.getAttribute("mensaje") %>
</body>
</html>