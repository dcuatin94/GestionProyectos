package com.uisrael.GestionProyectos.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.GestionProyectos.modelo.Asignacion;
import com.uisrael.GestionProyectos.repositorio.AsignacionRepositorio;
import com.uisrael.GestionProyectos.servicio.AsignacionServicio;

@Service
public class AsignacionServicioImpl implements AsignacionServicio{
	@Autowired
	private AsignacionRepositorio asignacionRepositorio;

	@Override
	public void insertarAsignacion(Asignacion asignacion) {
		try {
			asignacionRepositorio.save(asignacion);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Asignacion> listarAsignaciones() {
		return asignacionRepositorio.findAll();
	}

}
