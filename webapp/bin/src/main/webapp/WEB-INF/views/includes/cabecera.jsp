<%--cabecera.jsp --%>

<%--
     Cabeceras para los jsp.
     Autor: jonBarnes
     Version: 09/05/2017
  

 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%--HEAD--%>
<head>
<meta charset="UTF-8" />
<title>Ejercicio Tienda</title>
<!--Ficheros para llamar a bootstrap -->
	<!--Cargamos la css de bootstrap-->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	
	<!-- EL mio -->
	<link rel="stylesheet" href="css/fondo.css">
	<!--Metemos jquery-->
	<script src="js/jquery-1.12.4.min.js"></script>
	<!--Metemos javaScript-->
	<script src="js/bootstrap.min.js"></script>
	

</head>

<%--Empieza el Codigo --%>
<body class="container-fluid">

<%--Titulo. --%>
	<header class="text-center">
		<h1>CATALOGO</h1>
		<p>La mejor tienda online de productos unicos.</p>
	</header>
	<nav>
		<%--Botones en la parte superior. --%>
			<a class="btn btn-default" href="productosform?op=alta" role="button">Alta Producto</a>
			<a class="btn btn-default" href="productoscrud" role="button">Mantenimiento productos</a>
			
			<a class="btn btn-default" href="usuarioform?op=alta" role="button">Alta Usuarios</a>
			<a class="btn btn-default" href="usuariocrud" role="button">Mantenimiento usuarios</a>
			
			<a class="btn btn-default" href="listaproductos" role="button">Vista usuario</a>
			<a class="btn btn-default" href="carritocrud" role="button">Carrito</a>
			
			<a class="btn btn-default" href="listafacturas" role="button">Lista facturas</a>
			
			<a class="btn btn-default" href="login?opcion=logout" role="button">Logout</a>
	</nav>