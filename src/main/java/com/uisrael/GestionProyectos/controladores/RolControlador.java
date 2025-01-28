package com.uisrael.GestionProyectos.controladores;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.uisrael.GestionProyectos.modelo.Rol;
import com.uisrael.GestionProyectos.servicio.RolServicio;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RolControlador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RolServicio rolServicio;
	
	@GetMapping("/roles")
	public String Roles(Model model) {
		model.addAttribute("rol", new Rol());
		model.addAttribute("roles", rolServicio.listarRoles());
		return "/roles/listar";
	}
	
	@PostMapping("/rol/guardar")
	public String guardarRol(@ModelAttribute("rol") Rol rol) {
		rolServicio.insertarRol(rol);
		return "redirect:/roles";
	}
	
	@GetMapping("/rol/editar/{idRol}")
	public String editarRol(Model model, @PathVariable int idRol) {
		Rol rol = rolServicio.buscarPorId(idRol);
		model.addAttribute("rol", rol);
		model.addAttribute("roles", rolServicio.listarRoles());
		return "/roles/listar";
	}
	
	@GetMapping("/rol/eliminar/{idRol}")
	public String eliminarRol(Model model, @PathVariable int idRol) {
		Rol rol = rolServicio.buscarPorId(idRol);
		rol.setEstadoRegistro(false);
		rolServicio.insertarRol(rol);
		return "redirect:/roles";
	}
}
