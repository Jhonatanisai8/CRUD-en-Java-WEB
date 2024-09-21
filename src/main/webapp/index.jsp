
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <h1>Datos del Usuario</h1>
        <!-- enviamos los datos al servlet los datos mediante el doPost -->
        <form action="SvUsuarios" method="post"> 
            <p><label>Dni: </label><input type="type" name="dni"></p>
            <p><label>Nombre: </label><input type="type" name="nombre"></p>
            <p><label>Apellido: </label><input type="type" name="apellido"></p>
            <p><label>Telefono: </label><input type="type" name="telefono"></p>
            <button type="submit"> Enviar </button>
        </form>

        <h1>Ver la lista de los Usuarios: </h1>
        <p>Para ver la lista de los usuarios cargados haga clik aqui: </p>
        <form action="SvUsuarios" method="get">
            <button type="submit"> Mostrar Usuarios</button>
        </form>
    </body>

</html>
