package com.uisrael.GestionProyectos.controladores;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.GestionProyectos.servicio.ProyectoServicio;
import com.uisrael.GestionProyectos.servicio.TareaServicio;
import com.uisrael.GestionProyectos.servicio.UsuarioServicio;
import com.uisrael.GestionProyectos.modelo.Tarea;

@Controller
public class TareaControlador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProyectoServicio proyectoServicio;
	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired
	private TareaServicio tareaServicio;

	@GetMapping("/tarea")
	public String crearTarea(Model model) {	
		model.addAttribute("tarea", new Tarea());
		model.addAttribute("proyectos", proyectoServicio.listarProyectos());
		return "/tareas/form";
	}
	
	@PostMapping("/tarea/guardar")
	public String guardarTarea(@ModelAttribute("Tarea") Tarea tarea) {
		tareaServicio.insertarServicio(tarea);
		return "redirect:/tareas";
	}
	
	@GetMapping("/tarea/editar/{idTarea}")
	public String editarTarea(Model model, @PathVariable int idTarea) {
		model.addAttribute("tarea", tareaServicio.buscarTareaPorId(idTarea));
		model.addAttribute("proyectos", proyectoServicio.listarProyectos());
		return "/tarea/form";
	}
	
	@GetMapping("/tarea/eliminar/{idTarea}")
	public String EliminarTarea(Model model, @PathVariable int idTarea) {
		Tarea tarea = tareaServicio.buscarTareaPorId(idTarea);
		tarea.setEstadoRegistro(false);
		tareaServicio.insertarServicio(tarea);
		return "redirect:/tareas";
	}
	
	@GetMapping("/tareas")
	public String listarTareas(Model model) {
		model.addAttribute("tareas", tareaServicio.listarTareas());
		return "/tareas/listar";
	}
}
