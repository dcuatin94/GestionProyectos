package com.uisrael.GestionProyectos.controladores;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.GestionProyectos.modelo.Usuario;
import com.uisrael.GestionProyectos.servicio.RolServicio;
import com.uisrael.GestionProyectos.servicio.UsuarioServicio;

@Controller
public class UsuarioControlador implements Serializable{
	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired
	private RolServicio rolServicio;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GetMapping("/usuario")
	public String CrearUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("roles", rolServicio.listarRoles());
		return "/usuarios/form";
	}
	
	
	@PostMapping("/usuario/guardar")
	public String guardarUsuario(@ModelAttribute("Usuario") Usuario usuario) {
		usuarioServicio.insertarUsuario(usuario);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuario/editar/{idUsuario}")
	public String editarUsuario(Model model, @PathVariable int idUsuario) {
		model.addAttribute("usuario", usuarioServicio.buscarUsuarioPorId(idUsuario));
		model.addAttribute("roles", rolServicio.listarRoles());
		return "/usuarios/form";
	}
	
	@GetMapping("/usuario/eliminar/{idUsuario}")
	public String EliminarUsuario(Model model, @PathVariable int idUsuario) {
		Usuario usuario = usuarioServicio.buscarUsuarioPorId(idUsuario);
		usuario.setEstadoRegistro(false);
		usuarioServicio.insertarUsuario(usuario);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios")
	public String Usuarios(Model model) {
		model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
		return "/usuarios/listar";
	}
}
