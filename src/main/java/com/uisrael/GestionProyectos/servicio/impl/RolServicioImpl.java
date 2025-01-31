package com.uisrael.GestionProyectos.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.GestionProyectos.modelo.Rol;
import com.uisrael.GestionProyectos.repositorio.RolRepositorio;
import com.uisrael.GestionProyectos.servicio.RolServicio;

@Service
public class RolServicioImpl implements RolServicio{

	@Autowired
	private RolRepositorio rolRepositorio;
	@Override
	public void insertarRol(Rol rol) {
		try {
			rolRepositorio.save(rol);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}		
	}

	@Override
	public List<Rol> listarRoles() {
		return rolRepositorio.findByEstadoRegistro(true);
	}

	@Override
	public List<Rol> ordenarRolesPorNombre() {
		// TODO Auto-generated method stub
		return rolRepositorio.ordenarRolesPorNombre();
	}

	@Override
	public List<Rol> buscarRolesQueEmpieceCon(String prefijo) {
		// TODO Auto-generated method stub
		return rolRepositorio.buscarRolesQueEmpieceCon(prefijo);
	}

	@Override
	public List<Rol> buscarRolesQueTerminenCon(String sufijo) {
		// TODO Auto-generated method stub
		return rolRepositorio.buscarRolesQueTerminenCon(sufijo);
	}

	@Override
	public Rol buscarPorId(int idRol) {
		
		return rolRepositorio.findById(idRol).get();
	}

}
