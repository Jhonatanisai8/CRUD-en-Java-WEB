package com.jhonatan.clase02primerservlet.Logica;

import com.jhonatan.clase02primerservlet.Persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    //llamamos a los metodos de la clase ControladoraPersistencia
    public void crearUsuario(Usuario usuario) {
        controladoraPersistencia.crearUsuario(usuario);
    }

    public List<Usuario> traerUsuarios() {
        return controladoraPersistencia.traerUsuarios();
    }

    public void borrarUsuario(int idEliminar) {
        controladoraPersistencia.borrarUsuario(idEliminar);
    }

    public Usuario traerUsuario(int idEditar) {
        return controladoraPersistencia.traerUsuario(idEditar);
    }

    public void editarUsuario(Usuario usuario) throws Exception {
        controladoraPersistencia.editarUsuario(usuario);
    }
}
