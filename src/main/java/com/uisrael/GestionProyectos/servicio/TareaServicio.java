package com.uisrael.GestionProyectos.servicio;

import java.time.LocalDateTime;
import java.util.List;

import com.uisrael.GestionProyectos.modelo.Tarea;

public interface TareaServicio {
	public void insertarServicio(Tarea tarea);
	public List<Tarea> listarTareas();
	public List<Tarea> listarTareasAntesDe(LocalDateTime beforeDate);
	public List<Tarea> listarTareasDespuesDe(LocalDateTime afterDate);
	public List<Tarea> buscarTareasPorAnioMes(int anio, int mes);
}
