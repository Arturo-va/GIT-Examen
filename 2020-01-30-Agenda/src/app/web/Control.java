package app.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import app.modelo.Empleado;
import app.persistencia.AccesoContacto;

/**
 * Servlet implementation class Control
 */
@WebServlet("/control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String opcion = request.getParameter("accion");
		
		
		Contacto c1 = (Contacto) request.getAttribute("c1");
		AccesoContacto ae1 = new AccesoContacto();
		try {
			ae1.insertarEmpleado(c1);
			request.setAttribute("mensaje", "Alta exitosa");
			RequestDispatcher rq = request.getRequestDispatcher("/mensaje.jsp");
			rq.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		
		/*--------------------------------------------
		switch (opcion) {
		case "alta": 
			altaEmpleado(request, response);
			break;

		default:
			break;
		}
		----------------------------------------------*/
	}
	protected void altaEmpleado (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contacto c1 = (Contacto) request.getAttribute("e1");
		AccesoContacto ae1 = new AccesoContacto();
		try {
			ae1.insertarEmpleado(e1);
			request.setAttribute("mensaje", "Alta exitosa");
			RequestDispatcher rq = request.getRequestDispatcher("/mensaje.jsp");
			rq.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
	}	
		

}
