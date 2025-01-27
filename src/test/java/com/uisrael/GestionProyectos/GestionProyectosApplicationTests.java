package com.uisrael.GestionProyectos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.GestionProyectos.modelo.Asignacion;
import com.uisrael.GestionProyectos.modelo.Comentario;
import com.uisrael.GestionProyectos.modelo.Proyecto;
import com.uisrael.GestionProyectos.modelo.Rol;
import com.uisrael.GestionProyectos.modelo.Tarea;
import com.uisrael.GestionProyectos.modelo.Usuario;
import com.uisrael.GestionProyectos.servicio.AsignacionServicio;
import com.uisrael.GestionProyectos.servicio.ComentarioServicio;
import com.uisrael.GestionProyectos.servicio.ProyectoServicio;
import com.uisrael.GestionProyectos.servicio.RolServicio;
import com.uisrael.GestionProyectos.servicio.TareaServicio;
import com.uisrael.GestionProyectos.servicio.UsuarioServicio;

@SpringBootTest
class GestionProyectosApplicationTests {
	@Autowired
	private RolServicio rolServicio;
	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired
	private ProyectoServicio proyectoServicio;
	@Autowired
	private TareaServicio tareaServicio;
	@Autowired
	private ComentarioServicio comentarioServicio;
	@Autowired
	private AsignacionServicio asignacionServicio;

	@Test
	void contextLoads() {
		Rol administrador = new Rol();
		administrador.setNombre("Administrador");
		administrador.setEstadoRegistro(true);
		rolServicio.insertarRol(administrador);
		Rol master = new Rol();
		master.setNombre("Scrum Master");
		master.setEstadoRegistro(true);
		rolServicio.insertarRol(master);
		Rol gerente = new Rol();
		gerente.setNombre("Gerente");
		gerente.setEstadoRegistro(true);
		rolServicio.insertarRol(gerente);
		Rol disenador = new Rol();
		disenador.setNombre("Diseñador");
		disenador.setEstadoRegistro(true);
		rolServicio.insertarRol(disenador);
		Rol devops = new Rol();
		devops.setNombre("DevOps");
		devops.setEstadoRegistro(true);
		rolServicio.insertarRol(devops);
		for(Rol item : rolServicio.listarRoles()) {
			System.out.println("Rol: Nombre->"+item.getNombre()+",Id ->"+item.getIdRol());
		}
		
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Juan");
		usuario1.setApellido("Perez");
		usuario1.setUsername("jperez");
		usuario1.setPassword("password123");
		usuario1.setEmail("juan.perez@example.com");
		usuario1.setFechaCreation(LocalDateTime.now());
		usuario1.setEstadoRegistro(true);
		usuario1.setRol(administrador);   
		usuarioServicio.insertarUsuario(usuario1);

		Usuario usuario2 = new Usuario();
		usuario2.setNombre("Ana");
		usuario2.setApellido("Lopez");
		usuario2.setUsername("alopez");
		usuario2.setPassword("password456");
		usuario2.setEmail("ana.lopez@example.com");
		usuario2.setFechaCreation(LocalDateTime.now());
		usuario2.setEstadoRegistro(true);
		usuario2.setRol(master);
		usuarioServicio.insertarUsuario(usuario2);

		Usuario usuario3 = new Usuario();
		usuario3.setNombre("Carlos");
		usuario3.setApellido("Garcia");
		usuario3.setUsername("cgarcia");
		usuario3.setPassword("password789");
		usuario3.setEmail("carlos.garcia@example.com");
		usuario3.setFechaCreation(LocalDateTime.now());
		usuario3.setEstadoRegistro(true);
		usuario3.setRol(devops);
		usuarioServicio.insertarUsuario(usuario3);

		Usuario usuario4 = new Usuario();
		usuario4.setNombre("Maria");
		usuario4.setApellido("Fernandez");
		usuario4.setUsername("mfernandez");
		usuario4.setPassword("password101");
		usuario4.setEmail("maria.fernandez@example.com");
		usuario4.setFechaCreation(LocalDateTime.now());
		usuario4.setEstadoRegistro(true);
		usuario4.setRol(disenador);
		usuarioServicio.insertarUsuario(usuario4);

		Usuario usuario5 = new Usuario();
		usuario5.setNombre("Luis");
		usuario5.setApellido("Rodriguez");
		usuario5.setUsername("lrodriguez");
		usuario5.setPassword("password202");
		usuario5.setEmail("luis.rodriguez@example.com");
		usuario5.setFechaCreation(LocalDateTime.now());
		usuario5.setEstadoRegistro(true);
		usuario5.setRol(gerente);
		usuarioServicio.insertarUsuario(usuario5);

		for(Usuario item: usuarioServicio.listarUsuarios()) {
			System.out.println("Usuario:"+ item.getNombre()+" "+item.getApellido());
		}
	     
		Proyecto proyecto1 = new Proyecto();
		proyecto1.setNombre("Sistema de Gestión de Inventarios");
		proyecto1.setDescripcion("Desarrollo de un sistema para gestionar inventarios de una empresa.");
		proyecto1.setFechaInicio(LocalDate.of(2024, 1, 10));
		proyecto1.setFechaFin(LocalDate.of(2024, 5, 15));
		proyecto1.setEstadoRegistro(true);
		proyecto1.setUsuario(usuario1);
		proyectoServicio.insertarProyecto(proyecto1);

		Proyecto proyecto2 = new Proyecto();
		proyecto2.setNombre("Aplicación Móvil de Reservas");
		proyecto2.setDescripcion("Aplicación móvil para gestionar reservas en restaurantes.");
		proyecto2.setFechaInicio(LocalDate.of(2024, 2, 5));
		proyecto2.setFechaFin(LocalDate.of(2024, 6, 30));
		proyecto2.setEstadoRegistro(true);
		proyecto2.setUsuario(usuario2);
		proyectoServicio.insertarProyecto(proyecto2);

		Proyecto proyecto3 = new Proyecto();
		proyecto3.setNombre("Plataforma de E-learning");
		proyecto3.setDescripcion("Plataforma para gestionar cursos en línea.");
		proyecto3.setFechaInicio(LocalDate.of(2024, 3, 1));
		proyecto3.setFechaFin(null);
		proyecto3.setEstadoRegistro(true);
		proyecto3.setUsuario(usuario3);
		proyectoServicio.insertarProyecto(proyecto3);

		Proyecto proyecto4 = new Proyecto();
		proyecto4.setNombre("Sistema de Facturación Electrónica");
		proyecto4.setDescripcion("Sistema para la emisión de facturas electrónicas.");
		proyecto4.setFechaInicio(LocalDate.of(2023, 12, 1));
		proyecto4.setFechaFin(LocalDate.of(2024, 4, 1));
		proyecto4.setEstadoRegistro(true);
		proyecto4.setUsuario(usuario4);
		proyectoServicio.insertarProyecto(proyecto4);

		Proyecto proyecto5 = new Proyecto();
		proyecto5.setNombre("Portal Web para Eventos");
		proyecto5.setDescripcion("Portal para la gestión y publicación de eventos.");
		proyecto5.setFechaInicio(LocalDate.of(2024, 5, 1));
		proyecto5.setFechaFin(LocalDate.of(2024, 9, 1));
		proyecto5.setEstadoRegistro(false);
		proyecto5.setUsuario(usuario5);
		proyectoServicio.insertarProyecto(proyecto5);

		for(Proyecto item: proyectoServicio.listarProyectos()) {
			System.out.println("Proyecto:"+ item.getNombre());
		}

		Tarea tarea1 = new Tarea();
		tarea1.setNombre("Diseño de la base de datos");
		tarea1.setDescripcion("Diseñar la base de datos para el sistema.");
		tarea1.setFechaCreacion(LocalDateTime.of(2024, 1, 10, 9, 30));
		tarea1.setFechaVencimiento(LocalDateTime.of(2024, 1, 20, 17, 0));
		tarea1.setEstadoRegistro(true);
		tarea1.setProyecto(proyecto1);
		tareaServicio.insertarServicio(tarea1);

		Tarea tarea2 = new Tarea();
		tarea2.setNombre("Desarrollo de la API");
		tarea2.setDescripcion("Desarrollar el backend para el sistema de gestión.");
		tarea2.setFechaCreacion(LocalDateTime.of(2024, 2, 1, 10, 0));
		tarea2.setFechaVencimiento(LocalDateTime.of(2024, 2, 28, 18, 0));
		tarea2.setEstadoRegistro(true);
		tarea2.setProyecto(proyecto1);
		tareaServicio.insertarServicio(tarea2);

		Tarea tarea3 = new Tarea();
		tarea3.setNombre("Pruebas unitarias");
		tarea3.setDescripcion("Escribir y ejecutar pruebas unitarias para el sistema.");
		tarea3.setFechaCreacion(LocalDateTime.of(2024, 2, 15, 8, 30));
		tarea3.setFechaVencimiento(LocalDateTime.of(2024, 3, 5, 17, 0));
		tarea3.setEstadoRegistro(true);
		tarea3.setProyecto(proyecto2);
		tareaServicio.insertarServicio(tarea3);

		Tarea tarea4 = new Tarea();
		tarea4.setNombre("Implementación de la interfaz");
		tarea4.setDescripcion("Desarrollar la interfaz de usuario para el sistema.");
		tarea4.setFechaCreacion(LocalDateTime.of(2024, 1, 20, 11, 0));
		tarea4.setFechaVencimiento(LocalDateTime.of(2024, 2, 15, 17, 0));
		tarea4.setEstadoRegistro(true);
		tarea4.setProyecto(proyecto2);
		tareaServicio.insertarServicio(tarea4);

		Tarea tarea5 = new Tarea();
		tarea5.setNombre("Despliegue del sistema");
		tarea5.setDescripcion("Desplegar el sistema en el servidor de producción.");
		tarea5.setFechaCreacion(LocalDateTime.of(2024, 3, 1, 9, 0));
		tarea5.setFechaVencimiento(LocalDateTime.of(2024, 3, 10, 17, 0));
		tarea5.setEstadoRegistro(true);
		tarea5.setProyecto(proyecto3);
		tareaServicio.insertarServicio(tarea5);
		
		for(Tarea item: tareaServicio.listarTareas()) {
			System.out.println("Tarea Id:"+ item.getIdTarea() + " Titulo:"+ item.getNombre());
		}

		Asignacion asignacion1 = new Asignacion();
		asignacion1.setFechaAsignacion(LocalDate.of(2024, 1, 10));
		asignacion1.setEstadoRegistro(true);
		asignacion1.setUsuario(usuario1);  
		asignacion1.setTarea(tarea1);
		asignacionServicio.insertarAsignacion(asignacion1);

		Asignacion asignacion2 = new Asignacion();
		asignacion2.setFechaAsignacion(LocalDate.of(2024, 1, 15));
		asignacion2.setEstadoRegistro(true);
		asignacion2.setUsuario(usuario1); 
		asignacion2.setTarea(tarea2);  
		asignacionServicio.insertarAsignacion(asignacion2);

		Asignacion asignacion3 = new Asignacion();
		asignacion3.setFechaAsignacion(LocalDate.of(2024, 1, 20));
		asignacion3.setEstadoRegistro(true);
		asignacion3.setUsuario(usuario2);  
		asignacion3.setTarea(tarea3); 
		asignacionServicio.insertarAsignacion(asignacion3);

		Asignacion asignacion4 = new Asignacion();
		asignacion4.setFechaAsignacion(LocalDate.of(2024, 1, 25));
		asignacion4.setEstadoRegistro(true);
		asignacion4.setUsuario(usuario2); 
		asignacion4.setTarea(tarea4);  
		asignacionServicio.insertarAsignacion(asignacion4);

		Asignacion asignacion5 = new Asignacion();
		asignacion5.setFechaAsignacion(LocalDate.of(2024, 2, 1));
		asignacion5.setEstadoRegistro(true);
		asignacion5.setUsuario(usuario1); 
		asignacion5.setTarea(tarea5); 
		asignacionServicio.insertarAsignacion(asignacion5);
		for(Asignacion item: asignacionServicio.listarAsignaciones()) {
			System.out.println("Asignacion:"+ item.getIdAsignacion() + ", "+ item.getFechaAsignacion());
		}

		Comentario comentario1 = new Comentario();
		comentario1.setContenido("Este es el primer comentario.");
		comentario1.setFechaCreacion(LocalDate.of(2024, 1, 15));
		comentario1.setEstadoRegistro(true);
		comentario1.setUsuario(usuario1);
		comentario1.setTarea(tarea1);
		comentarioServicio.insertarComentario(comentario1);

		Comentario comentario2 = new Comentario();
		comentario2.setContenido("Este es el segundo comentario.");
		comentario2.setFechaCreacion(LocalDate.of(2024, 1, 18));
		comentario2.setEstadoRegistro(true);
		comentario2.setUsuario(usuario2);  
		comentario2.setTarea(tarea2);
		comentarioServicio.insertarComentario(comentario2);

		Comentario comentario3 = new Comentario();
		comentario3.setContenido("Este es el tercer comentario.");
		comentario3.setFechaCreacion(LocalDate.of(2024, 1, 20));
		comentario3.setEstadoRegistro(true);
		comentario3.setUsuario(usuario3);
		comentario3.setTarea(tarea3);
		comentarioServicio.insertarComentario(comentario3);

		Comentario comentario4 = new Comentario();
		comentario4.setContenido("Este es el cuarto comentario.");
		comentario4.setFechaCreacion(LocalDate.of(2024, 1, 22));
		comentario4.setEstadoRegistro(true);
		comentario4.setUsuario(usuario4); 
		comentario4.setTarea(tarea4);
		comentarioServicio.insertarComentario(comentario4);

		Comentario comentario5 = new Comentario();
		comentario5.setContenido("Este es el quinto comentario.");
		comentario5.setFechaCreacion(LocalDate.of(2024, 1, 25));
		comentario5.setEstadoRegistro(true);
		comentario5.setUsuario(usuario5);
		comentario5.setTarea(tarea5);   
		for(Comentario item: comentarioServicio.listarComentarioI()) {
			System.out.println("Comentario:"+ item.getIdComentario() + ","+ item.getContenido());
		}
		// 1.- Buscar usuario por nombre y apellido
		System.out.println("Buscar por nombre y apellido");
		for(Usuario item: usuarioServicio.buscarPorNombreyApellido("Juan", "Perez")) {
			System.out.println("ID:"+ item.getIdUsuario() + " Nombre:"+ item.getNombre() + " Apellido:" + item.getApellido());
		}
		// 2.- Buscar usuario por dominio
		System.out.println("Buscar por dominio");
		for(Usuario item: usuarioServicio.buscarUsuarioPorEmailDomain("example")) {
			System.out.println("ID:"+ item.getIdUsuario() + " Nombre:"+ item.getNombre() + " Apellido:" + item.getApellido() + " Correo:"+ item.getEmail());
		}
		
		// 3.- Listar usuarios activos
		System.out.println("Buscar Activos");
		for(Usuario item: usuarioServicio.buscarUsuariosActivos()) {
			System.out.println("ID:"+ item.getIdUsuario() + " Nombre:"+ item.getNombre() + " Apellido:" + item.getApellido() );
		}
		
		// 4. Mostrar roles ordenados por nombre
		System.out.println("Roles ordenados por nombre");
		for(Rol item: rolServicio.ordenarRolesPorNombre()) {
			System.out.println("Id:"+item.getIdRol()+" Nombre:"+item.getNombre());
		}
		// 5. Buscar roles que empiecen con
		System.out.println("Mostrar roles que empiecen con");
		for(Rol item: rolServicio.buscarRolesQueEmpieceCon("A")) {
			System.out.println("Id:"+item.getIdRol()+" Nombre:"+item.getNombre());
		}
		// 6. Buscar roles que terminen con
		System.out.println("Mostrar roles que terminen en");
		for(Rol item: rolServicio.buscarRolesQueEmpieceCon("r")) {
			System.out.println("Id:"+item.getIdRol()+" Nombre:"+item.getNombre());
		}
		// 7. Buscar Proyectos Que Iniciaron Entre un rango de fechas
		System.out.println("Buscar Proyecto que Iniciaron entre un rango de fechas");
		LocalDate startDate = LocalDate.parse("2024-01-01");
		LocalDate endDate = LocalDate.parse("2024-03-01");
		for(Proyecto item: proyectoServicio.buscarProyectosQueIniciaronEntre(startDate, endDate)) {
			System.out.println("Titulo:"+item.getNombre() + "| Fecha Inicio:" + item.getFechaInicio());
		}
		// 8. Buscar proyectos por año
		System.out.println("Buscar proyectos por año");
		for (Proyecto item: proyectoServicio.buscarProyectosPorAnio(2024)) {
			System.out.println("Titulo:"+item.getNombre() + "Fecha Inicio:" + item.getFechaFin());
		}
		// 9. Mostrar proyectos no finalizados
		System.out.println("Mostrar proyecto no finalizados");
		for(Proyecto item: proyectoServicio.mostrarProyectosNoFinalizados()) {
			System.out.println("Titulo:"+item.getNombre()+" Fecha Inicio:"+item.getFechaInicio()+" Fecha Fin:"+ item.getFechaFin());
		}
		// 10. Listar tareas antes de una fecha
		System.out.println("Listar tareas antes de una fecha");
		LocalDateTime beforeDate = LocalDateTime.parse("2024-03-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		for(Tarea item: tareaServicio.listarTareasAntesDe(beforeDate)) {
			System.out.println("Id:"+ item.getIdTarea() + " Titulo:"+ item.getNombre() + "Fecha Creacion:" + item.getFechaCreacion());
		}
		// 11. Listar tareas despues de una fecha
		System.out.println("Listar tareas despues de una fecha");
		LocalDateTime afterDate = LocalDateTime.parse("2024-03-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		for(Tarea item: tareaServicio.listarTareasDespuesDe(afterDate)) {
			System.out.println("Id:"+ item.getIdTarea() + " Titulo:"+ item.getNombre() + "Fecha Creacion:" + item.getFechaCreacion());
		}
		// 12. Listar tareas antes de una fecha
		System.out.println("Buscar tareas por año y mes");
		for(Tarea item: tareaServicio.buscarTareasPorAnioMes(2024, 02)) {
			System.out.println("Id:"+ item.getIdTarea() + " Titulo:"+ item.getNombre() + "Fecha Creacion:" + item.getFechaCreacion());
		}
		// 13. Buscar comentarios por id del usuario
		System.out.println("Buscar comentarios por id del Usuario");
		for(Comentario item: comentarioServicio.buscarComentariosPorIdUsuario(2)) {
			System.out.println("Comentario:"+ item.getContenido() + " Usuario:"+item.getUsuario().getNombre());
		}
		// 14. Mostrar usuarios que hicieron comentario
		System.out.println("Mostra usuarios que agregaron comentarios");
		for(Usuario item: comentarioServicio.usuariosQueCrearonComentarios()) {
			System.out.println("Usuario:"+item.getNombre() + " " + item.getApellido());
		}
		// 15. Numero de comentarios por tarea
		System.out.println("Total comentarios por tarea: " +  comentarioServicio.numeroComentariosPorTarea(1));
		
	}
}
