<%@page import="com.jhonatan.clase02primerservlet.Logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>

        //traemos el usuario del servlet
        <%Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");%>

        <h1>Datos del Usuario</h1>
        <!-- enviamos los datos al servlet los datos mediante el doPost -->
        <form action="SvEditar" method="post"> 
            <p><label>Dni: </label><input type="type" name="dni" value="<%=usu.getDni()%>"></p>
            <p><label>Nombre: </label><input type="type" name="nombre" value="<%=usu.getNombre()%>"></p>
            <p><label>Apellido: </label><input type="type" name="apellido" value="<%=usu.getApellido()%>"></p>
            <p><label>Telefono: </label><input type="type" name="telefono"value="<%=usu.getTelefono()%>"></p>
            <button type="submit"> Guardar </button>
        </form> 

    </body>
</html>
