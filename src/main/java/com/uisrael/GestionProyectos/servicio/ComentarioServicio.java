package com.uisrael.GestionProyectos.servicio;

import java.util.List;

import com.uisrael.GestionProyectos.modelo.Comentario;
import com.uisrael.GestionProyectos.modelo.Usuario;

public interface ComentarioServicio {
	public void insertarComentario(Comentario comentario);
	public List<Comentario> listarComentarioI();
	public List<Comentario> buscarComentariosPorIdUsuario(int usuarioId);
	public List<Usuario> usuariosQueCrearonComentarios();
	public long numeroComentariosPorTarea(int tareaId);
}
