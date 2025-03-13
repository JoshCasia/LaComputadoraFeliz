package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ensamblarComputadora")
public class EnsamblarComputadoraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreComputadora = request.getParameter("nombreComputadora");
        String nombreUsuario = request.getParameter("nombreUsuario");
        String fechaEnsamblaje = request.getParameter("fechaEnsamblaje");

        try (Connection conexion = obtenerConexion()) {
            // Verificar que las piezas estén disponibles
            if (verificarPiezasDisponibles(conexion, nombreComputadora)) {
                // Ensamblar la computadora
                ensamblarComputadora(conexion, nombreComputadora, nombreUsuario, fechaEnsamblaje);
                response.sendRedirect("../pages/ensamblaje.jsp?mensaje=Computadora ensamblada correctamente");
            } else {
                response.sendRedirect("../pages/ensamblaje.jsp?error=No hay suficientes piezas disponibles");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("../pages/ensamblaje.jsp?error=Error en la base de datos");
        }
    }

    private boolean verificarPiezasDisponibles(Connection conexion, String nombreComputadora) throws SQLException {
        // Implementa la lógica para verificar las piezas disponibles
        return true; // Cambia esto según tu lógica
    }

    private void ensamblarComputadora(Connection conexion, String nombreComputadora, String nombreUsuario, String fechaEnsamblaje) throws SQLException {
        // Implementa la lógica para ensamblar la computadora
    }

    private Connection obtenerConexion() throws SQLException {
        // Implementa la lógica para obtener una conexión a la base de datos
        return null;
    }
}