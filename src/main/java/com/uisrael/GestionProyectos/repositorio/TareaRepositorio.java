package com.uisrael.GestionProyectos.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.GestionProyectos.modelo.Tarea;

public interface TareaRepositorio extends JpaRepository<Tarea, Integer>{
	@Query("Select t from Tarea t Where t.fechaCreacion < :beforeDate")
	public List<Tarea> listarTareasAntesDe(@Param("beforeDate") LocalDateTime beforeDate);
	
	@Query("Select t from Tarea t Where t.fechaCreacion > :afterDate")
	public List<Tarea> listarTareasDespuesDe(@Param("afterDate") LocalDateTime afterDate);
	
	@Query("Select t from Tarea t Where YEAR(t.fechaCreacion)=?1 and MONTH(t.fechaCreacion) = ?2")
	public List<Tarea> buscarTareasPorAnioMes(int anio, int mes);

}
