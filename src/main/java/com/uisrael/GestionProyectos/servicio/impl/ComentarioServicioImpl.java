package com.uisrael.GestionProyectos.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.GestionProyectos.modelo.Comentario;
import com.uisrael.GestionProyectos.modelo.Usuario;
import com.uisrael.GestionProyectos.repositorio.ComentarioRepositorio;
import com.uisrael.GestionProyectos.servicio.ComentarioServicio;

@Service
public class ComentarioServicioImpl implements ComentarioServicio{
	@Autowired
	private ComentarioRepositorio comentarioRepositorio;

	@Override
	public void insertarComentario(Comentario comentario) {
		try {
			comentarioRepositorio.save(comentario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Comentario> listarComentarioI() {
		return comentarioRepositorio.findAll();
	}

	@Override
	public List<Comentario> buscarComentariosPorIdUsuario(int usuarioId) {
		// TODO Auto-generated method stub
		return comentarioRepositorio.buscarComentariosPorIdUsuario(usuarioId);
	}

	@Override
	public List<Usuario> usuariosQueCrearonComentarios() {
		// TODO Auto-generated method stub
		return comentarioRepositorio.usuariosQueCrearonComentarios();
	}

	@Override
	public long numeroComentariosPorTarea(int tareaId) {
		// TODO Auto-generated method stub
		return comentarioRepositorio.numeroComentariosPorTarea(tareaId);
	}

}
