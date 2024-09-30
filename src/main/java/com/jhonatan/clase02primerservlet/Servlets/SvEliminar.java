package com.jhonatan.clase02primerservlet.Servlets;

import com.jhonatan.clase02primerservlet.Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminar", urlPatterns = {"/SvEliminar"})
public class SvEliminar extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    //utlilizamos el doPost para eliminar
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //obtenemos el id con el metodo getParameter(parametroF);
        int idEliminar = Integer.parseInt(request.getParameter("id_usuario"));
        //llamamos al metodo borrar de la clase controladora
        controladora.borrarUsuario(idEliminar);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
