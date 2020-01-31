<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(request.getParameter("nombre")!=null) { %>
	<jsp:useBean id="e1" class="app.modelo.Empleado" scope="request">
		<jsp:setProperty property="*" name="e1"/>
	</jsp:useBean>
	<% pageContext.setAttribute("accion", "alta", pageContext.REQUEST_SCOPE); %>
	<jsp:forward page="control"></jsp:forward>
<% } %>
<form action="altaempleado.jsp" method="post">
	Nombre 		<input type="text" name="nombre"/><br>
	Num. DNI: 	<input type="text" name="numdni"/><br>
	<input type="submit" value="alta"/>
</form>
</body>
</html>