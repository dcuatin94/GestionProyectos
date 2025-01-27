package com.uisrael.GestionProyectos.servicio;

import java.util.List;

import com.uisrael.GestionProyectos.modelo.Usuario;

public interface UsuarioServicio {
	public void insertarUsuario(Usuario usuario);
	public List<Usuario> listarUsuarios();
	public List<Usuario> buscarPorNombreyApellido(String nombre, String apellido);
	public List<Usuario> buscarUsuarioPorEmailDomain(String dominio);
	public List<Usuario> buscarUsuariosActivos();
}
