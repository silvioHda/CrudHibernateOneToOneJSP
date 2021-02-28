package com.mx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mx.dao.NovioDao;
import com.mx.entidad.Novio;

/**
 * Servlet implementation class NovioCtl
 */
public class NovioCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovioCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		metodo(request, response);
	}
	
	protected void metodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset-UTF-8");
		RequestDispatcher rd = null;
		NovioDao novioDao = null;
		Novio novio=null;
		
		try(PrintWriter out = response.getWriter()) {
			if (request.getParameter("btnGuardar") != null) {
				novioDao = new NovioDao();
				novio = new Novio();
				novio.setId(Integer.parseInt(request.getParameter("id")));
				novio.setNombre(request.getParameter("nombre"));
				novio.setApp(request.getParameter("app"));
				novio.setEdad(Integer.parseInt(request.getParameter("edad")));
				novio.setTrabajo(request.getParameter("trabajo"));
				novio.setTelefono(request.getParameter("telefono"));
				//novio.setEdad(Integer.parseInt(request.getParameter("edad")));
				novioDao.guardar(novio);
				
			}else if(request.getParameter("btnEliminar") != null) {
				novioDao = new NovioDao();
				novio = new Novio();
				novio.setId(Integer.parseInt(request.getParameter("id")));
				novioDao.eliminar(novio);
			}else if(request.getParameter("btnEditar")!=null) {
				novioDao = new NovioDao();
				novio = new Novio();
				novio.setId(Integer.parseInt(request.getParameter("id")));
				novio.setNombre(request.getParameter("nombre"));
				novio.setApp(request.getParameter("app"));
				novio.setEdad(Integer.parseInt(request.getParameter("edad")));
				novio.setTrabajo(request.getParameter("trabajo"));
				novio.setTelefono(request.getParameter("telefono"));
				//novio.setEdad(Integer.parseInt(request.getParameter("edad")));
				novioDao.editar(novio);
			}
			rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		} catch (Exception e) {
			System.out.println("Error controller-> "+e.getMessage());
		}
	}


}
