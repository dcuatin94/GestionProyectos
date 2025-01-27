package com.uisrael.GestionProyectos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.GestionProyectos.modelo.Comentario;
import com.uisrael.GestionProyectos.modelo.Usuario;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Integer>{
	@Query("Select c From Comentario c Where c.usuario.id = :usuarioId")
	public List<Comentario> buscarComentariosPorIdUsuario(@Param("usuarioId") int UsuarioId);
	
	@Query("Select DISTINCT c.usuario From Comentario c")
	public List<Usuario> usuariosQueCrearonComentarios();
	
	@Query("Select COUNT(c) From Comentario c Where c.tarea.id = :tareaId")
	public Long numeroComentariosPorTarea(@Param("tareaId") int tareaId);
}
