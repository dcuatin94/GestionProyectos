package com.uisrael.GestionProyectos.servicio.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.GestionProyectos.modelo.Tarea;
import com.uisrael.GestionProyectos.repositorio.TareaRepositorio;
import com.uisrael.GestionProyectos.servicio.TareaServicio;

@Service
public class TareasServicioImpl implements TareaServicio{
	@Autowired
	private TareaRepositorio tareaRepositorio;

	@Override
	public void insertarServicio(Tarea tarea) {
		try {
			tareaRepositorio.save(tarea);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Tarea> listarTareas() {
		// TODO Auto-generated method stub
		return tareaRepositorio.findAll();
	}

	@Override
	public List<Tarea> listarTareasAntesDe(LocalDateTime beforeDate) {
		
		// TODO Auto-generated method stub
		System.err.println(beforeDate);
		return tareaRepositorio.listarTareasAntesDe(beforeDate);
	}

	@Override
	public List<Tarea> listarTareasDespuesDe(LocalDateTime afterDate) {
		// TODO Auto-generated method stub
		return tareaRepositorio.listarTareasDespuesDe(afterDate);
	}

	@Override
	public List<Tarea> buscarTareasPorAnioMes(int anio, int mes) {
		// TODO Auto-generated method stub
		return tareaRepositorio.buscarTareasPorAnioMes(anio, mes);
	}

	@Override
	public Tarea buscarTareaPorId(int idTarea) {
		return tareaRepositorio.findById(idTarea).get();
	}


}
