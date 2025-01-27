package com.uisrael.GestionProyectos.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Data
@Entity
public class Tarea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTarea;
	@Column(length = 100)
	private String nombre;
	@Column(length = 255, nullable = true)
	private String descripcion;
	private LocalDateTime fechaCreacion;
	@Column(nullable = true)
	private LocalDateTime fechaVencimiento;
	private boolean estadoRegistro;
	
	@OneToOne(mappedBy = "tarea", cascade = CascadeType.REFRESH)
	private Asignacion asignacion;
	
	@OneToMany(mappedBy = "tarea", cascade = CascadeType.REFRESH)
	private List<Comentario> comentarios = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="proyecto_id")
	private Proyecto proyecto; 
}
