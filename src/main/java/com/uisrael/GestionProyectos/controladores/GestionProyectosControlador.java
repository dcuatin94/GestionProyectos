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
