package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Persona;
import com.example.demo.repository.IPersonaRepo;

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaRepo iPersonaRepo;

	@Override
	public List<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		
		return this.iPersonaRepo.buscarTodos();
	}

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iPersonaRepo.buscarPorId(id);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaRepo.actualizar(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iPersonaRepo.eliminar(id);
	}

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaRepo.guardar(persona);
	}

}
