package controlador;

import modelo.Componente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComponenteController {
    private Connection conexion; // Asume que ya tienes una conexión a la base de datos

    public void guardarComponente(Componente componente) {
        String sql = "INSERT INTO Componente (nombre, costo, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, componente.getNombre());
            stmt.setDouble(2, componente.getCosto());
            stmt.setInt(3, componente.getCantidad());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Componente> obtenerComponentes() {
        List<Componente> componentes = new ArrayList<>();
        String sql = "SELECT nombre, costo, cantidad FROM Componente";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Componente componente = new Componente();
                componente.setNombre(rs.getString("nombre"));
                componente.setCosto(rs.getDouble("costo"));
                componente.setCantidad(rs.getInt("cantidad"));
                componentes.add(componente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentes;
    }
}