<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área de Administración - La Computadora Feliz</title>
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
        <section class="administracion">
            <h2>Área de Administración</h2>

            <!-- Formulario para crear un nuevo usuario -->
            <form action="../actions/procesarUsuario.jsp" method="POST">
                <h3>Crear Nuevo Usuario</h3>
                <label for="nombreUsuario">Nombre de Usuario:</label>
                <input type="text" id="nombreUsuario" name="nombreUsuario" required>

                <label for="passwordUsuario">Contraseña:</label>
                <input type="password" id="passwordUsuario" name="passwordUsuario" required>

                <label for="rolUsuario">Rol:</label>
                <select id="rolUsuario" name="rolUsuario" required>
                    <option value="1">Ensamblaje</option>
                    <option value="2">Ventas</option>
                    <option value="3">Administración</option>
                </select>

                <button type="submit">Crear Usuario</button>
            </form>

            <!-- Lista de usuarios registrados -->
            <div class="lista-usuarios">
                <h3>Usuarios Registrados</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Nombre de Usuario</th>
                            <th>Rol</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Filas de usuarios se agregarán dinámicamente -->
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