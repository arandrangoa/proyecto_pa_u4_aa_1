package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Persona;
import com.example.demo.service.IPersonaService;

@Controller
@RequestMapping("/personas")
//Como regla general poner el nombre del recurso que estamos utilizando
public class PersonaController {
	
	@Autowired
	private IPersonaService iPersonaService;
	
	@GetMapping("/nuevaPersona")
	public String paginaNuevaPersona(Persona persona) {
		return "vistaNuevaPersona";
	}
	
	@PostMapping("/insertar")
	public String insertarPersona(Persona persona) {
		this.iPersonaService.guardar(persona);
		return "guardado";
	}
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Persona> lista=this.iPersonaService.buscarTodos();
		modelo.addAttribute("personas", lista);   //Es el modelo que se maneja en este caso las personas que se declararon en html
		return "vistaListaPersonas";
	}
	
	@DeleteMapping("/borrar/{id}")
	public String borrarPersona(@PathVariable("id") Integer id) {
		this.iPersonaService.eliminar(id);
		return "redirect:/personas/buscar"; //para redirigir a una vista que ya teniamos se lo hace asi 
	}
	
	@GetMapping("/buscarPorId/{id}")
	public String buscarPorId (@PathVariable("id") Integer id, Model modelo){
		Persona persona=this.iPersonaService.buscarPorId(id);
		modelo.addAttribute("persona", persona);
		return "vistaPersona";
		
	}
	
	@PutMapping("/actualizar/{id}")
	public String actualizarPorId(@PathVariable("id") Integer id, Persona persona) { //Se debe aclarar la persona que se utuiliza en el html
		persona.setId(id);
		this.iPersonaService.actualizar(persona);
		return "redirect:/personas/buscar";
	}

}
