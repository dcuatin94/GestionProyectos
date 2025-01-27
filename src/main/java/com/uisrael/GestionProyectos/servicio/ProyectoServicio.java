package com.uisrael.GestionProyectos.servicio;

import java.time.LocalDate;
import java.util.List;

import com.uisrael.GestionProyectos.modelo.Proyecto;

public interface ProyectoServicio {
	public void insertarProyecto(Proyecto proyecto);
	public List<Proyecto> listarProyectos();
	public List<Proyecto> buscarProyectosQueIniciaronEntre(LocalDate startDate, LocalDate endDate);
	public List<Proyecto> buscarProyectosPorAnio(int anio);
	public List<Proyecto> mostrarProyectosNoFinalizados();
}
