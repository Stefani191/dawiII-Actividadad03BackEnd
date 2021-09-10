package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {

//Implement methods that's go in the controller

	/*
	 * Consulta de Medicamento por ID
	 * 
	 * Consulta de Medicamento por Nombre use LIke
	 * 
	 * Consulta de Medicamento por Stock
	 */
		//It's the method's return		    Input/The user enter id
	public Optional<Medicamento> buscarPorId( int idMedicamento );
	
	@Query("select * from medicamento m where m.nombre like: param_nombre")
	public abstract List<Medicamento> buscarPorNombre( String nombre );
	
	public abstract List<Medicamento> buscarPorStock( int stock );

}
