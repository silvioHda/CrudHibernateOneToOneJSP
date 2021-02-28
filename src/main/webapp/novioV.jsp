<html>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import='java.util.*'%>
<%@page import='com.mx.dao.NovioDao'%>
<%@page import='com.mx.entidad.Novio'%>
<body>
	<h2>Gestión de Novios</h2>



	<link
		href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->

	<%
		NovioDao dao = new NovioDao();
	List<Novio> lista = new ArrayList<Novio>();
	%>
	
	
<div class="span3">
    <h2>Agregar Novio</h2>
    <form action="NovioCtl" method="POST">
    <label>Id</label>
    <input type="text" name="id" class="span3">
    <label>Nombre</label>
    <input type="text" name="nombre" class="span3">
    <label>App</label>
    <input type="text" name="app" class="span3">
    <label>Telefono</label>
    <input type="text" name="telefono" class="span3">
    <label>Trabajo</label>
    <input type="text" name="trabajo" class="span3">
    <label>Edad</label>
    <input type="text" name="edad" class="span3">
    
    <input type="submit" value="Guardar" name="btnGuardar" class="btn btn-primary pull-right">
    <input type="submit" value="Eliminar" name="btnEliminar" class="btn btn-danger pull-right">
	<input type="submit" value="Editar" name="btnEditar" class="btn btn-warning pull-right">
	    
    <div class="clearfix"></div>
    </form>
</div>
	

	<div class="container">
		<div class="row">
			<div class="span5">
				<table class="table table-striped table-condensed">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>App</th>
							<th>Telefono</th>
							<th>Trabajo</th>
							<th>Edad</th>
						</tr>
					</thead>
					<tbody>
						<%
							lista = dao.mostrar();
							for (Novio n : lista) 
							{
						%>
						<tr>
							<td><%=n.getId()%></td>
							<td><%=n.getNombre()%></td>
							<td><%=n.getApp()%></td>
							<td><%=n.getTelefono()%></td>
							<td><%=n.getTrabajo()%></td>
							<td><%=n.getEdad()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
