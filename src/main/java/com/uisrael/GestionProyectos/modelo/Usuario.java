package com.uisrael.GestionProyectos.modelo;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	@Column(length = 100)
	private String nombre;
	@Column(length = 100)
	private String apellido;
	@Column(length = 80)
	private String username;
	@Column(length = 255)
	private String password;
	@Column(length = 255)
	private String email;
	@Column(updatable = false)
	private LocalDateTime fechaCreation;
	private boolean estadoRegistro = true;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REFRESH)
	private List<Asignacion> asignaciones = new ArrayList<>();
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REFRESH)
	private List<Comentario> comentarios = new ArrayList<>();
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REFRESH)
	private List<Proyecto> proyecto = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "rol_id")
	private Rol rol;
	
	
}
