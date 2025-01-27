package com.uisrael.GestionProyectos.servicio;

import java.util.List;
import com.uisrael.GestionProyectos.modelo.Rol;

public interface RolServicio {
	public void insertarRol(Rol rol);
	public List<Rol> listarRoles();
	public List<Rol> ordenarRolesPorNombre();
	public List<Rol> buscarRolesQueEmpieceCon(String prefijo);
	public List<Rol> buscarRolesQueTerminenCon(String sufijo);
}
