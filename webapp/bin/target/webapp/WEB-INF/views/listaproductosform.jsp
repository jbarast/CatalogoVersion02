<%--listaproductosform.jsp --%>
<%--

  Vista para añadir productos al carrito.
  autor: jonBarnes
  version: 30/06/2017

 --%>

<%--Cabecera --%>
<%@ include file="includes/cabecera.jsp" %>

<%--Para el encoding. --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%--Cargamos las librerias. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h2>Formulario de productos</h2>

<%--Llamamos a clases. --%>
<jsp:useBean id="producto" scope="request"
             class="com.ipartek.jonBarnes.tipos.Producto"/>


<%--"Creacion" de los formularios. --%>
<form action="listaproductos" method="post">

<%--Nombre. --%>
<fieldset>
<label for="nombre">Nombre</label>

<input id="nombre" name="nombre"
       required="required" value="${producto.nombre}"

        <c:if test="${param.op == 'anadir'}">
            readonly="readonly"
        </c:if>
/>

<%--Que solo se vea el dato de nombre a la hora de borrar. --%>

    </fieldset>


    <%--id, en el alta no aparece por que se crea automaticamente. --%>


    <%--El BOTON para validar el formulario. --%>
    <fieldset>
    <input type="submit" value="${fn:toUpperCase(param.op)}" />


    <input type="hidden" name="opform" value="${param.op}" />
    </fieldset>
    </form>



    <%--pie --%>
    <%@ include file="includes/pie.jsp" %>