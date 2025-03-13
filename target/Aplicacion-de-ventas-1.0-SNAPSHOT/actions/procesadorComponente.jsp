<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.Componente, controlador.ComponenteController" %>
<%
    // Obtener los datos del formulario
    String nombre = request.getParameter("nombreComponente");
    double costo = Double.parseDouble(request.getParameter("costoComponente"));
    int cantidad = Integer.parseInt(request.getParameter("cantidadComponente"));

    // Crear un objeto Componente
    Componente componente = new Componente();
    componente.setNombre(nombre);
    componente.setCosto(costo);
    componente.setCantidad(cantidad);

    // Guardar el componente en la base de datos
    ComponenteController controller = new ComponenteController();
    controller.guardarComponente(componente);

    // Redirigir de vuelta a la página de ensamblaje
    response.sendRedirect("../pages/ensamblaje.jsp");
%>


