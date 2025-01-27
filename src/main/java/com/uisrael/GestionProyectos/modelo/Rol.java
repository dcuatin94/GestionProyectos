package com.uisrael.GestionProyectos.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Rol implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	@Column(length = 100)
	private String nombre;
	private boolean estadoRegistro;
	
	@OneToMany(mappedBy = "rol", cascade = CascadeType.REFRESH)
	private List<Usuario> usuarios = new ArrayList<>();
}
