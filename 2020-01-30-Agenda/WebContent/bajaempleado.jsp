<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if(request.getParameter("idEmpleado")!=null) { %>
	<!-- Recogemos el idEmpleado -->
	<jsp:useBean id="e1" class="app.modelo.Empleado" scope="request">
		<jsp:setProperty property="idempleado" name="e1"/>	<!-- el property hace referencia al nombre de la propiededad de la clase Empleado -->
	</jsp:useBean>
	<% pageContext.setAttribute("accion", "baja", pageContext.REQUEST_SCOPE); %>
	<jsp:forward page="control"></jsp:forward>	<!-- Lo redirigimos al Servlet "contorl.class"  -->
<% } %>
<form action="bajaempleado.jsp" method="post">
	Id. Empleado <input type="text" name="idEmpleado"/><br>
	<input type="submit" value="baja"/>
</form>

</body>
</html>