package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;

@Service
public class MedicamentoServicelmpl implements MedicamentoService{

	@Autowired
	private MedicamentoRepository repository;
	
	@Override
	public Optional<Medicamento> buscarPorId( int idMedicamento) {
		// TODO Auto-generated method stub
		return repository.findById(idMedicamento);//
	}

	@Override
	public List<Medicamento> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repository.findByNombreLike(nombre);
	}

	@Override
	public List<Medicamento> buscarPorStock(int stock) {
		// TODO Auto-generated method stub
		return repository.findByStock(stock);
	}

	@Override
	public List<Medicamento> listadoMedicamentos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Medicamento registroMedicamento(Medicamento obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

}
