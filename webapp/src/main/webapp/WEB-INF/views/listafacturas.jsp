<%--
  Created by IntelliJ IDEA.
  User: jonBarnes
  Date: 26/07/2017
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%--cabecera --%>
<%@ include file="includes/cabecera.jsp"%>

<%--Para el encoding. --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%--Librerias de jstl que necesitamos. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<h1>Facturas del Usuario ${usuario.username} </h1>

<%--Tabla que muestra los usuarios --%>
<table class="table table-hover text-centered">

    <%--Cabecera de la tabla. --%>
    <thead>
    <tr>
        <th>Factura</th>
        <th>Fecha</th>

    </tr>
    </thead>

    <%--Fila de las tablas. --%>
    <tbody>
    <c:forEach var="factura" items="${facturas}" >
        <tr>

            <td>${factura.id}</td>
            <td>${factura.date}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>



<%--pie --%>
<%@ include file="includes/pie.jsp"%>