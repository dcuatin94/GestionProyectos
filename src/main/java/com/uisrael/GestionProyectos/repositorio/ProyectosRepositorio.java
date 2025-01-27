package com.uisrael.GestionProyectos.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.GestionProyectos.modelo.Proyecto;

public interface ProyectosRepositorio extends JpaRepository<Proyecto, Integer>{
	@Query("Select p from Proyecto p Where p.fechaInicio BETWEEN :startDate AND :endDate")
	public List<Proyecto> buscarProyectosQueIniciaronEntre(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	
	@Query("Select p from Proyecto p Where YEAR(p.fechaInicio) = :anio")
	public List<Proyecto> buscarProyectosPorAnio(@Param("anio") int anio);
	
	@Query("Select p from Proyecto p Where p.fechaFin is null")
	public List<Proyecto> mostrarProyectosNoFinalizados();
}
