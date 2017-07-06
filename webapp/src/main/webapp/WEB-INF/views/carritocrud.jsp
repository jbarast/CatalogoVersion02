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

            <td>${carrito.nombre}</td>
            <td>${carrito.descripcion}</td>
            <td>${carrito.precio}</td>
            <td>${carrito.stock}</td>
            <td><IMG src="${carrito.rutaImagen}" width="100" height="100"/></td>
            <td>${carrito.cantidad}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<!--Boton para comprar -->
<a class="btn btn-default" href="factura" role="button">Comprar</a>

<%--pie --%>
<%@ include file="includes/pie.jsp"%>