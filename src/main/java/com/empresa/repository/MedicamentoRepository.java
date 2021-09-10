package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

	public abstract List<Medicamento> findByNombreLike( String nombre );//The name of the entity must have the same name in the name method

	public abstract List<Medicamento> findByStock( int stock );
}
