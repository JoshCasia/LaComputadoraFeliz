<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área de Ventas - La Computadora Feliz</title>
    <link rel="stylesheet" href="../styles/styles.css">
</head>
<body>
    <header>
        <h1>La Computadora Feliz</h1>
        <nav>
            <ul>
                <li><a href="../index.jsp">Inicio</a></li>
                <li><a href="ensamblaje.jsp">Ensamblaje</a></li>
                <li><a href="ventas.jsp">Ventas</a></li>
                <li><a href="administracion.jsp">Administración</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="ventas">
            <h2>Área de Ventas</h2>

            <!-- Formulario para registrar una venta -->
            <form action="../actions/procesarVenta.jsp" method="POST">
                <h3>Registrar Nueva Venta</h3>
                <label for="clienteNIT">NIT del Cliente:</label>
                <input type="text" id="clienteNIT" name="clienteNIT" required>

                <label for="clienteNombre">Nombre del Cliente:</label>
                <input type="text" id="clienteNombre" name="clienteNombre" required>

                <label for="clienteDireccion">Dirección del Cliente:</label>
                <input type="text" id="clienteDireccion" name="clienteDireccion" required>

                <label for="computadoraVendida">Computadora Vendida:</label>
                <select id="computadoraVendida" name="computadoraVendida" required>
                    <!-- Opciones de computadoras ensambladas -->
                    <option value="1">Gamer Pro</option>
                    <option value="2">Oficina Plus</option>
                </select>

                <button type="submit">Registrar Venta</button>
            </form>

            <!-- Lista de ventas registradas -->
            <div class="lista-ventas">
                <h3>Ventas Registradas</h3>
                <table>
                    <thead>
                        <tr>
                            <th>NIT del Cliente</th>
                            <th>Nombre del Cliente</th>
                            <th>Computadora Vendida</th>
                            <th>Fecha de Venta</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Filas de ventas se agregarán dinámicamente -->
                    </tbody>
                </table>
            </div>
        </section>
    </main>

    <footer>
        <p>&copy; 2025 La Computadora Feliz. Todos los derechos reservados.</p>
    </footer>
</body>
</html>