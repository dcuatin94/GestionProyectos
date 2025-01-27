package com.uisrael.GestionProyectos.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.GestionProyectos.servicio.AsignacionServicio;
import com.uisrael.GestionProyectos.servicio.ComentarioServicio;
import com.uisrael.GestionProyectos.servicio.ProyectoServicio;
import com.uisrael.GestionProyectos.servicio.RolServicio;
import com.uisrael.GestionProyectos.servicio.TareaServicio;
import com.uisrael.GestionProyectos.servicio.UsuarioServicio;
import com.uisrael.GestionProyectos.modelo.*;

@Controller
public class GestionProyectosControlador {
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private RolServicio rolServicio;
	
	@Autowired
	private ProyectoServicio proyectoServicio;
	
	@Autowired
	private TareaServicio tareaServicio;
	
	@Autowired
	private ComentarioServicio comentarioServicio;
	
	@Autowired
	private AsignacionServicio asignacionServicio;
	
	@GetMapping("/index")
	public String Index(Model model) {
		model.addAttribute("texto", "Daniel");
		return "/usuarios/listar";
	}
	
	@GetMapping("/usuarios")
	public String Usuarios(Model model) {
		
		model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
		return "/usuarios/listar";
	}
	
	@GetMapping("/usuario")
	public String Usuario(Model model) {
		model.addAttribute("roles", rolServicio.listarRoles());
		model.addAttribute("usuario", new Usuario());
		return "/usuarios/form";
	}
	
	@GetMapping("/roles")
	public String Roles(Model model) {
		model.addAttribute("rol", new Rol());
		model.addAttribute("roles", rolServicio.listarRoles());
		return "/roles/listar";
	}
	
	@GetMapping("/proyecto")
	public String Proyecto(Model model) {
		model.addAttribute("proyecto", new Proyecto());
		return "/proyectos/form";
	}
	
	@GetMapping("/proyectos")
	public String Proyectos(Model model) {
		model.addAttribute("proyectos", proyectoServicio.listarProyectos());
		return "/proyectos/listar";
	}
	
	@GetMapping("/tarea")
	public String Tarea(Model model) {
		model.addAttribute("tarea", new Tarea());
		model.addAttribute("proyectos", proyectoServicio.listarProyectos());
		model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
		return "/tareas/form";
	}
	
	@GetMapping("/tareas")
	public String Tareas(Model model) {
		model.addAttribute("tareas", tareaServicio.listarTareas());
		return "/tareas/listar";
	}
	
	@GetMapping("/comentarios")
	public String Comentarios(Model model) {
		model.addAttribute("comentarios", comentarioServicio.listarComentarioI());
		return "/comentarios/listar";
	}
	
	@GetMapping("/asignaciones")
	public String Asignaciones(Model model) {
		model.addAttribute("asignaciones", asignacionServicio.listarAsignaciones());
		return "/asignaciones/listar";
	}
}
