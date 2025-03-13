<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controlador.EnsamblarComputadoraServlet" %>
<%
    // Obtener los datos del formulario
    String nombreComputadora = request.getParameter("nombreComputadora");
    String nombreUsuario = request.getParameter("nombreUsuario");
    String fechaEnsamblaje = request.getParameter("fechaEnsamblaje");

    // Llamar al servlet para procesar el ensamblaje
    EnsamblarComputadoraServlet servlet = new EnsamblarComputadoraServlet();
    servlet.doPost(request, response);
%>
