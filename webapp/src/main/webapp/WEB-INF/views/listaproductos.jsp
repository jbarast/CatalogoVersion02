<%--listaproductos.jsp --%>

<%--
     Vista para listaproductos.
     autor= jonBarnes
     version = 30/06/2017

 --%>

<%--cabecera --%>
<%@ include file="includes/cabecera.jsp"%>

<%--Para el encoding. --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%--Cargamos la libreria core de jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%--Titulo --%>
<h2>Lista de productos.</h2>
<%--Tabla --%>
<table class="table table-hover text-centered">

<%--Titulos de las columnas. --%>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Precio</th>
			<th>Stock</th>
			<th>Imagen Producto</th>
			<th>Añadir al Carrito</th>

		</tr>
	</thead>
	<tbody>
	
	<%--Bucle de lectura de elementos de la tienda. --%>
		<c:forEach items="${requestScope.productos}" var="producto">
			<tr>
				<td>${producto.id}</td>
				<td>${producto.nombre}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio} €</td>
				<td>${producto.stock}</td>
				<td><IMG src="${producto.rutaImagen}" width="100" height="100"/></td>
				<td><a href="?op=anadir&id=${producto.id}" class="btn btn-primary btn-lg active" role="button">Comprar</a></td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>



<%--pie --%>
<%@ include file="includes/pie.jsp"%>