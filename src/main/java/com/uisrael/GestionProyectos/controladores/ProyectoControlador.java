package com.uisrael.GestionProyectos.controladores;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.GestionProyectos.modelo.Proyecto;
import com.uisrael.GestionProyectos.servicio.ProyectoServicio;
import com.uisrael.GestionProyectos.servicio.UsuarioServicio;

@Controller
public class ProyectoControlador implements Serializable{
	@Autowired
	private ProyectoServicio proyectoServicio;
	@Autowired
	private UsuarioServicio usuarioServicio;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GetMapping("/proyecto")
	public String crearProyecto(Model model) {
		model.addAttribute("proyecto", new Proyecto());
		model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
		return "/proyectos/form";
	}
	
	@PostMapping("/proyecto/guardar")
	public String guardarProyecto(@ModelAttribute("Proyecto") Proyecto proyecto) {
		proyectoServicio.insertarProyecto(proyecto);
		return "redirect:/proyectos";
	}
	
	@GetMapping("/proyecto/editar/{idProyecto}")
	public String editarProyecto(Model model, @PathVariable int idProyecto) {
		model.addAttribute("proyecto", proyectoServicio.buscarProyectoPorId(idProyecto));
		model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
		return "/proyectos/form";
	}
	
	@GetMapping("/proyecto/eliminar/{idProyecto}")
	public String EliminarProyecto(Model model, @PathVariable int idProyecto) {
		Proyecto proyecto = proyectoServicio.buscarProyectoPorId(idProyecto);
		proyecto.setEstadoRegistro(false);
		proyectoServicio.insertarProyecto(proyecto);
		return "redirect:/proyectos";
	}
	
	@GetMapping("/proyectos")
	public String Proyectos(Model model) {
		model.addAttribute("proyectos", proyectoServicio.listarProyectos());
		return "/proyectos/listar";
	}
}