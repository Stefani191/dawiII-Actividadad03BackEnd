package com.empresa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medicamento")
@Getter
@Setter

public class Medicamento {
	/*
	 * `idMedicamento` int(11) NOT NULL AUTO_INCREMENT, `nombre` text, `precio`
	 * double DEFAULT NULL, `stock` int(11) DEFAULT NULL, `laboratorio` text,
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedicamento;

	private String nombre;
	private double precio;
	private int stock;
	private String laboratorio;

}
