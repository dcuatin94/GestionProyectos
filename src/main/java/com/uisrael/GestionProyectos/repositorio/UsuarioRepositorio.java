package com.uisrael.GestionProyectos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.GestionProyectos.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	@Query("select u from Usuario u WHERE u.nombre=:nombre and u.apellido=:apellido")
	public List<Usuario> buscarPorNombreyApellido(@Param("nombre") String nombre,@Param("apellido") String apellido);

	@Query("select u from Usuario u WHERE u.email LIKE %:dominio%")
	public List<Usuario> buscarUsuarioPorEmailDomain(@Param("dominio") String dominio);
	
	@Query("select u from Usuario u WHERE u.estadoRegistro=true")
	public List<Usuario> buscarUsuariosActivos();
}
