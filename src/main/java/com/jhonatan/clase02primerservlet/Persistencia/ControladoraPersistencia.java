package com.jhonatan.clase02primerservlet.Persistencia;

import com.jhonatan.clase02primerservlet.Logica.Usuario;
import com.jhonatan.clase02primerservlet.Persistencia.exceptions.NonexistentEntityException;
import java.util.List;

public class ControladoraPersistencia {

    UsuarioJpaController usuarioJpaController = new UsuarioJpaController();

    //metodos
    public void crearUsuario(Usuario usuario) {
        usuarioJpaController.create(usuario);
    }

    public List<Usuario> traerUsuarios() {
        //nos trae todos los usuario de la bd
        return usuarioJpaController.findUsuarioEntities();
    }

    public void borrarUsuario(int idEliminar) {
        try {
            usuarioJpaController.destroy(idEliminar);
        } catch (NonexistentEntityException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
