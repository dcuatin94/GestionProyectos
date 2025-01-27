package com.uisrael.GestionProyectos.servicio.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.GestionProyectos.modelo.Proyecto;
import com.uisrael.GestionProyectos.repositorio.ProyectosRepositorio;
import com.uisrael.GestionProyectos.servicio.ProyectoServicio;

@Service
public class ProyectoServicioImpl implements ProyectoServicio{
	@Autowired
	private ProyectosRepositorio proyectoRepositio;

	@Override
	public void insertarProyecto(Proyecto proyecto) {
		try {
			proyectoRepositio.save(proyecto);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

	@Override
	public List<Proyecto> listarProyectos() {
		return proyectoRepositio.findAll();
	}

	@Override
	public List<Proyecto> buscarProyectosQueIniciaronEntre(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return proyectoRepositio.buscarProyectosQueIniciaronEntre(startDate, endDate);
	}

	@Override
	public List<Proyecto> buscarProyectosPorAnio(int anio) {
		// TODO Auto-generated method stub
		return proyectoRepositio.buscarProyectosPorAnio(anio);
	}

	@Override
	public List<Proyecto> mostrarProyectosNoFinalizados() {
		// TODO Auto-generated method stub
		return proyectoRepositio.mostrarProyectosNoFinalizados();
	}
	
}
