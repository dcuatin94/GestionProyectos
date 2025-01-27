package com.uisrael.GestionProyectos.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Asignacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAsignacion;
	private LocalDate fechaAsignacion;
	private boolean estadoRegistro;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="tarea_id")
	private Tarea tarea; 
}
