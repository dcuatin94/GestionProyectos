package com.uisrael.GestionProyectos.controladores;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GestionProyectosControlador {
	
	@GetMapping("/index")
	public String Index(Model model) {
		model.addAttribute("texto", "Daniel");
		return "/usuarios/listar";
	}
	
	
	
	
//	@GetMapping("/tarea")
//	public String Tarea(Model model) {
//		model.addAttribute("tarea", new Tarea());
//		model.addAttribute("proyectos", proyectoServicio.listarProyectos());
//		model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
//		return "/tareas/form";
//	}
//	
//	@GetMapping("/tareas")
//	public String Tareas(Model model) {
//		model.addAttribute("tareas", tareaServicio.listarTareas());
//		return "/tareas/listar";
//	}
//	
//	@GetMapping("/comentarios")
//	public String Comentarios(Model model) {
//		model.addAttribute("comentarios", comentarioServicio.listarComentarioI());
//		return "/comentarios/listar";
//	}
//	
//	@GetMapping("/asignaciones")
//	public String Asignaciones(Model model) {
//		model.addAttribute("asignaciones", asignacionServicio.listarAsignaciones());
//		return "/asignaciones/listar";
//	}
}
