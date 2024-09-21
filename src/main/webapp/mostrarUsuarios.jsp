
<%@page import="com.jhonatan.clase02primerservlet.Logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Usuarios</title>
    </head>
    <body>
        <h1>Lista de Usuarios</h1>
        <%
            //creamos una lista de usuarios y traemos el atributo de la sesion 
            List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
            int contador = 1;
            for (Usuario usu : listaUsuarios) {
        %>
                    <p><b>Usuario Nº <%=contador%> </b></p>
                    <p>Id: <%=usu.getId()%></p>
                    <p>Dni: <%=usu.getDni()%> </p>   
                    <p>Nombre: <%=usu.getNombre()%></p>   
                    <p>Apellido: <%=usu.getApellido()%></p>   
                    <p>Telefono: <%=usu.getTelefono()%></p>   
                    <p>-----------------------------------</p>
                    <%contador = contador +1;%>
        <% }%>
    </body>
</html>
