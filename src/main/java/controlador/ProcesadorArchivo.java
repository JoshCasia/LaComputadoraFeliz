package controlador;

import modelo.ConexionBD;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class ProcesadorArchivo {

    public static void procesarArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rutaArchivo), StandardCharsets.UTF_8));
             Connection conexion = ConexionBD.obtenerConexion()) {
            
            String linea;
            
            while ((linea = br.readLine()) != null) {
                procesarLinea(linea, conexion);                
            }
                
            System.out.println("Procesamiento completado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void procesarLinea(String linea, Connection conexion) {
        try {
            if (linea.startsWith("USUARIO")) {
                String[] datos = extraerParametros(linea);
                
                // Verificar si ya existe el usuario
                PreparedStatement psCheck = conexion.prepareStatement("SELECT COUNT(*) FROM Usuario WHERE nombre = ?");
                psCheck.setString(1, datos[0]);
                ResultSet rs = psCheck.executeQuery();
                rs.next();

                if (rs.getInt(1) == 0) {  // Solo inserta si no existe
                PreparedStatement psInsert = conexion.prepareStatement("INSERT INTO Usuario (nombre, password, id_rol) VALUES (?, ?, ?)");
                psInsert.setString(1, datos[0]);
                psInsert.setString(2, datos[1]);
                psInsert.setInt(3, Integer.parseInt(datos[2]));
                psInsert.executeUpdate();
                }
                
                PreparedStatement ps = conexion.prepareStatement("INSERT INTO Usuario (nombre, password, id_rol) VALUES (?, ?, ?)");
                ps.setString(1, datos[0]);
                ps.setString(2, datos[1]);
                ps.setInt(3, Integer.parseInt(datos[2]));
                ps.executeUpdate();
            }
           
            else if (linea.startsWith("PIEZA")) {
                String[] datos = extraerParametros(linea);
                PreparedStatement ps = conexion.prepareStatement("INSERT INTO Pieza (nombre, costo) VALUES (?, ?)");
                ps.setString(1, datos[0]);
                ps.setDouble(2, Double.parseDouble(datos[1]));
                ps.executeUpdate();
            } 
            else if (linea.startsWith("COMPUTADORA")) {
                String[] datos = extraerParametros(linea);
                PreparedStatement ps = conexion.prepareStatement("INSERT INTO Computadora (nombre, precio) VALUES (?, ?)");
                ps.setString(1, datos[0]);
                ps.setDouble(2, Double.parseDouble(datos[1]));
                ps.executeUpdate();
            } 
            else if (linea.startsWith("ENSAMBLE_PIEZA")) {
                String[] datos = extraerParametros(linea);
                
                // Obtener ID de la computadora
                PreparedStatement psComputadora = conexion.prepareStatement("SELECT id_computadora FROM Computadora WHERE nombre = ?");
                psComputadora.setString(1, datos[0]);
                ResultSet rsComputadora = psComputadora.executeQuery();
                
                // Obtener ID de la pieza
                PreparedStatement psPieza = conexion.prepareStatement("SELECT id_pieza FROM Pieza WHERE nombre = ?");
                psPieza.setString(1, datos[1]);
                ResultSet rsPieza = psPieza.executeQuery();
                
                if (rsComputadora.next() && rsPieza.next()) {
                    int idComputadora = rsComputadora.getInt("id_computadora");
                    int idPieza = rsPieza.getInt("id_pieza");
                    int cantidad = Integer.parseInt(datos[2]);

                    PreparedStatement psInsert = conexion.prepareStatement("INSERT INTO Ensamble_Pieza (id_computadora, id_pieza, cantidad) VALUES (?, ?, ?)");
                    psInsert.setInt(1, idComputadora);
                    psInsert.setInt(2, idPieza);
                    psInsert.setInt(3, cantidad);
                    psInsert.executeUpdate();
                } else {
                    System.out.println("Error: Computadora o pieza no encontrada.");
                }
            } 
            else if (linea.startsWith("ENSAMBLAR_COMPUTADORA")) {
                String[] datos = extraerParametros(linea);
                
                // Obtener ID de la computadora
                PreparedStatement psComputadora = conexion.prepareStatement("SELECT id_computadora FROM Computadora WHERE nombre = ?");
                psComputadora.setString(1, datos[0]);
                ResultSet rsComputadora = psComputadora.executeQuery();
                
                // Obtener ID del usuario
                PreparedStatement psUsuario = conexion.prepareStatement("SELECT id_usuario FROM Usuario WHERE nombre = ?");
                psUsuario.setString(1, datos[1]);
                ResultSet rsUsuario = psUsuario.executeQuery();
                
                if (rsComputadora.next() && rsUsuario.next()) {
                    int idComputadora = rsComputadora.getInt("id_computadora");
                    int idUsuario = rsUsuario.getInt("id_usuario");
                    String fecha = datos[2];

                    PreparedStatement psInsert = conexion.prepareStatement("INSERT INTO Ensamblar_Computadora (id_computadora, id_usuario, fecha) VALUES (?, ?, ?)");
                    psInsert.setInt(1, idComputadora);
                    psInsert.setInt(2, idUsuario);
                    psInsert.setDate(3, Date.valueOf(convertirFecha(fecha)));
                    psInsert.executeUpdate();
                } else {
                    System.out.println("Error: Computadora o usuario no encontrado.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[] extraerParametros(String linea) {
        return linea.substring(linea.indexOf("(") + 1, linea.indexOf(")")).replace("\"", "").split(", ");
    }

    private static String convertirFecha(String fecha) {
        String[] partes = fecha.split("/");
        return partes[2] + "-" + partes[1] + "-" + partes[0]; // Convierte de dd/mm/yyyy a yyyy-mm-dd
    }

    public static void main(String[] args) {
        procesarArchivo("C:/Users/Joshua/Documents/NetBeansProjects/Aplicacion-de-ventas/prueba.txt");  
    }
}
