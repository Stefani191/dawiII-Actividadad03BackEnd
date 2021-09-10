package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository repository;
	

	@Override
	public List<Alumno> listaAlumno() {
		return repository.findAll();
	}

	@Override
	public Alumno insertaActualizaAlumno(Alumno obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Alumno> buscaPorId(int idAlumno) {
		// TODO Auto-generated method stub
		return repository.findById(idAlumno);//In this case, It returns an optional student
	}

	@Override
	public void eliminarPorId(int idAlumno) {
		// TODO Auto-generated method stub
		repository.deleteById(idAlumno);
		
	}

	@Override
	public List<Alumno> buscarPorDni(String dni) {
		// TODO Auto-generated method stub
		return repository.findByDni(dni);
	}


	
	

}
