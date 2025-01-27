package com.uisrael.GestionProyectos.servicio;

import java.util.List;

import com.uisrael.GestionProyectos.modelo.Asignacion;

public interface AsignacionServicio {
	public void insertarAsignacion(Asignacion asignacion);
	public List<Asignacion> listarAsignaciones();
}
