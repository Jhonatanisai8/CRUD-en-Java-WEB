package com.jhonatan.clase02primerservlet.Servlets;

import com.jhonatan.clase02primerservlet.Logica.Controladora;
import com.jhonatan.clase02primerservlet.Logica.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
Método getParameter :
se utilixa del lado del servlet  para obtener el valor de un parametro enviado por el cliente
via los metodos doGet o doPost
EJEMPLO:
String dato = request.getParametrer("txtNombre");
 */
@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

    //instancia de la clase controladora
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    /*METODOS DO GET Y DO POST SE GENERAN AUTOMATICAMENTE*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        List<Usuario> listaUsuarios = new ArrayList<>();
        //llamamos a un metodo de la clase controladora
        listaUsuarios = controladora.traerUsuarios();

        //obtenemos la sesion 
        HttpSession miSession = request.getSession();

        //le seteamos el atributo listaUsuarios
        miSession.setAttribute("listaUsuarios", listaUsuarios);

        //generamos la respuesta
        response.sendRedirect("mostrarUsuarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        //obetenemos los datos
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");

        //creamos el usuaurio y seteamos los datos
        Usuario usuario = new Usuario();
        usuario.setDni(dni);
        usuario.setApellido(apellido);
        usuario.setNombre(nombre);
        usuario.setTelefono(telefono);

        //llamamos al metodo
        controladora.crearUsuario(usuario);
        response.sendRedirect("index.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
