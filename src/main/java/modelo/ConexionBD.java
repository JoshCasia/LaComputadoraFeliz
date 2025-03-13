package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Configuración de la conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/EnsamblajeComputadoras"; // Cambia el nombre de la BD
    private static final String USUARIO = "root";  // Cambia según tu configuración
    private static final String PASSWORD = "1234567890";  // Cambia según tu configuración

    // Método para obtener una conexión a la base de datos
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    // Método para probar la conexión
    public static void main(String[] args) {
        Connection conexion = ConexionBD.obtenerConexion();
        if (conexion != null) {
            System.out.println("¡Conexión exitosa!");
        } else {
            System.out.println("Error en la conexión.");
        }
    }
}
