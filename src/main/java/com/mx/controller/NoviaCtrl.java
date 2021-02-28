package com.mx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mx.dao.NoviaDao;
import com.mx.entidad.Novia;
import com.mx.entidad.Novio;

/**
 * Servlet implementation class noviaCtrl
 */
public class NoviaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoviaCtrl() {
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
		metodo(request,response);
		doGet(request, response);
	}

	protected void metodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset-UTF-8");
		RequestDispatcher rd = null;
		NoviaDao noviaDao = null;
		Novia novia=null;
		
		try(PrintWriter out = response.getWriter()) {
			if (request.getParameter("btnGuardar") != null) {
				noviaDao = new NoviaDao();
				novia = new Novia();
				novia.setId(Integer.parseInt(request.getParameter("id")));
				novia.setNombre(request.getParameter("nombre"));
				novia.setApp(request.getParameter("app"));
				novia.setEdad(Integer.parseInt(request.getParameter("edad")));
				novia.setPasatiempo(request.getParameter("pasatiempo"));
				novia.setEstatura(Double.parseDouble(request.getParameter("estatura")));
				//novia.setEdad(Integer.parseInt(request.getParameter("edad")));
				novia.setNovio(new Novio(Integer.parseInt(request.getParameter("idNovio"))));
				noviaDao.guardar(novia);
				
			}else if(request.getParameter("btnEliminar") != null) {
				noviaDao = new NoviaDao();
				novia = new Novia();
				novia.setId(Integer.parseInt(request.getParameter("id")));
				noviaDao.eliminar(novia);
			}else if(request.getParameter("btnEditar")!=null) {
				noviaDao = new NoviaDao();
				novia = new Novia();
				novia.setId(Integer.parseInt(request.getParameter("id")));
				novia.setNombre(request.getParameter("nombre"));
				novia.setApp(request.getParameter("app"));
				novia.setEdad(Integer.parseInt(request.getParameter("edad")));
				novia.setPasatiempo(request.getParameter("pasatiempo"));
				novia.setEstatura(Double.parseDouble(request.getParameter("estatura")));
				//novia.setEdad(Integer.parseInt(request.getParameter("edad")));
				novia.setNovio(new Novio(Integer.parseInt(request.getParameter("idNovio"))));
				noviaDao.editar(novia);
			}
			rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		} catch (Exception e) {
			System.out.println("Error controller-> "+e.getMessage());
		}
	}
}
	

