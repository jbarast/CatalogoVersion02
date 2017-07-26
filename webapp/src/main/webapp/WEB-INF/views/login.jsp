<%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 26/07/2017
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>

<%--cabecera --%>
<%@ include file="includes/cabecera.jsp" %>


<%--Para el encoding. --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%--Cargamos la clase usuario. --%>
<jsp:useBean id="usuario" scope="request"
             class="com.ipartek.jonBarnes.tipos.Usuario" />

<h2>Login</h2>

<%--El formulario. --%>
<form action="login" method="post">
    <fieldset>
        <label for="nombre">Nombre</label> <input id="nombre" name="nombre"
                                                  required="required" minlength="4" value="${usuario.username}" />
    </fieldset>
    <fieldset>
        <label for="pass">Contraseña</label> <input type="password" id="pass"
                                                    name="pass" />
    </fieldset>
    <fieldset>
        <input type="submit" value="Login" />

    </fieldset>
</form>



<%--El pie de la pagina. --%>
<%@ include file="includes/pie.jsp" %>
