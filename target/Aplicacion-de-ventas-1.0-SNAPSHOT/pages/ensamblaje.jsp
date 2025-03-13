<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área de Ensamblaje - La Computadora Feliz</title>
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
        <section class="ensamblaje">
            <h2>Área de Ensamblaje</h2>

            <!-- Formulario para ensamblar una computadora -->
            <form action="../actions/procesarEnsamblaje.jsp" method="POST">
                <h3>Ensamblar Computadora</h3>
                <label for="nombreComputadora">Nombre de la Computadora:</label>
                <input type="text" id="nombreComputadora" name="nombreComputadora" required>

                <label for="nombreUsuario">Nombre del Usuario:</label>
                <input type="text" id="nombreUsuario" name="nombreUsuario" required>

                <label for="fechaEnsamblaje">Fecha de Ensamblaje:</label>
                <input type="date" id="fechaEnsamblaje" name="fechaEnsamblaje" required>

                <button type="submit">Ensamblar Computadora</button>
            </form>
        </section>
    </main>

    <footer>
        <p>&copy; 2025 La Computadora Feliz. Todos los derechos reservados.</p>
    </footer>
</body>
</html>