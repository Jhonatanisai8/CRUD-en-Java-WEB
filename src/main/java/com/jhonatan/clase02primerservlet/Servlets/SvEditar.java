/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jhonatan.clase02primerservlet.Servlets;

import com.jhonatan.clase02primerservlet.Logica.Controladora;
import com.jhonatan.clase02primerservlet.Logica.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //obtenemos el id
        int idEditar = Integer.parseInt(request.getParameter("id_usuarioEditar"));
        Usuario usuario = control.traerUsuario(idEditar);

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("usuEditar", usuario);

        //redirigimoss 
        response.sendRedirect("editar.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //obetenemos los datos
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");

        //traemos el usuario
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuEditar");

        //modificmos los valors
        usuario.setDni(dni);
        usuario.setApellido(apellido);
        usuario.setNombre(nombre);
        usuario.setTelefono(telefono);

        try {
            //llamamos al metodo
            control.editarUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(SvEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
