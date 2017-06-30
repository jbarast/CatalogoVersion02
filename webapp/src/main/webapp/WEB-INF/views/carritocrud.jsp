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
<h2>Carrito</h2>
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
        <th>Cantidad</th>


    </tr>
    </thead>
    <tbody>

    <%--Bucle de lectura de elementos de la tienda. --%>
    <c:forEach items="${requestScope.carrito}" var="carrito">
        <tr>
            <td>${carrito.producto.id}</td>
            <td>${carrito.producto.nombre}</td>
            <td>${carrito.producto.descripcion}</td>
            <td>${carrito.producto.precio} €</td>
            <td>${carrito.producto.stock}</td>
            <td>${producto.cantidad}</td>
            <td><IMG src="${producto.rutaImagen}" width="100" height="100"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>



<%--pie --%>
<%@ include file="includes/pie.jsp"%>