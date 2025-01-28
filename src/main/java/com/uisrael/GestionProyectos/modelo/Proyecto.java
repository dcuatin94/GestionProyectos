package com.uisrael.GestionProyectos.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Proyecto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProyecto;
	@Column(length = 100)
	private String nombre;
	@Column(length = 255, nullable = true)
	private String descripcion;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio;
	@Column(nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaFin;
	private boolean estadoRegistro = true;
	
	@OneToMany(mappedBy = "proyecto")
	private List<Tarea> tareas = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
