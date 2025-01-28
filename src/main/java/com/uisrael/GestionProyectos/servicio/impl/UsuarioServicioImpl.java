package com.uisrael.GestionProyectos.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.GestionProyectos.modelo.Usuario;
import com.uisrael.GestionProyectos.repositorio.UsuarioRepositorio;
import com.uisrael.GestionProyectos.servicio.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public void insertarUsuario(Usuario usuario) {
		try {
			usuarioRepositorio.save(usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}
		
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public List<Usuario> buscarPorNombreyApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.buscarPorNombreyApellido(nombre, apellido);
	}

	@Override
	public List<Usuario> buscarUsuarioPorEmailDomain(String dominio) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.buscarUsuarioPorEmailDomain(dominio);
	}

	@Override
	public List<Usuario> buscarUsuariosActivos() {
		// TODO Auto-generated method stub
		return usuarioRepositorio.buscarUsuariosActivos();
	}

	@Override
	public Usuario buscarUsuarioPorId(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.findById(idUsuario).get();
	}

}
