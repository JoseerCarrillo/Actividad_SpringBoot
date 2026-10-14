package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Estudiante;
import com.ejemplo.demo.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteService {
	private final EstudianteRepository repository;
	 public EstudianteService(EstudianteRepository repository) {
		 this.repository = repository;
	 }
	 public List<Estudiante> listar() {
		 return repository.findAll();
	 }
	 public Estudiante guardar(Estudiante estudiante) {
		 return repository.save(estudiante);
	 }
}
