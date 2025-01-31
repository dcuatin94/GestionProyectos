package com.uisrael.GestionProyectos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.GestionProyectos.modelo.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Integer> {
	@Query("Select r from Rol r ORDER BY r.nombre ASC ")
	public List<Rol> ordenarRolesPorNombre();
	
	@Query("Select r from Rol r Where r.nombre LIKE :prefijo%")
	public List<Rol> buscarRolesQueEmpieceCon(@Param("prefijo")String prefijo);
	
	@Query("Select r from Rol r Where r.nombre LIKE %:sufijo")
	public List<Rol> buscarRolesQueTerminenCon(@Param("sufijo")String sufijo);
	
	public List<Rol> findByEstadoRegistro(boolean estadoRegistro);
}
