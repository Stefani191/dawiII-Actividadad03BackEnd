package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumno() {
		List<Alumno> lista = service.listaAlumno();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Alumno> insertaAlumno(@RequestBody Alumno obj) {
		if (obj == null) {
			return ResponseEntity.noContent().build();
		} else {
			obj.setIdAlumno(0);
			Alumno objSalida = service.insertaActualizaAlumno(obj);
			return ResponseEntity.ok(objSalida);
		}

	}

	@PutMapping //
	@ResponseBody // returns json
	public ResponseEntity<Alumno> buscarPorIdAlumno(@RequestBody Alumno obj) {
		// If it's null
		if (obj == null) {
			return ResponseEntity.badRequest().build();
		} else {
			Optional<Alumno> optAlumno = service.buscaPorId(obj.getIdAlumno());// Call method from service here
			if (optAlumno.isPresent()) {
				Alumno objSalida = service.insertaActualizaAlumno(obj);
				return ResponseEntity.ok(objSalida);
			} else {
				return ResponseEntity.badRequest().build();
			}
		}

	}

	@DeleteMapping("/{paramId}") // This param comes in the route/url
	@ResponseBody
	public ResponseEntity<Alumno> eliminarPorId(/* And put here */@PathVariable("paramId") int idAlumno) {
		Optional<Alumno> optAlumno = service.buscaPorId(idAlumno);
		if (optAlumno.isPresent()) {
			service.eliminarPorId(idAlumno);
			Optional<Alumno> objSalida = service.buscaPorId(idAlumno);
			if (objSalida.isPresent()) {
				return ResponseEntity.badRequest().build();
			} else {
				return ResponseEntity.ok(optAlumno.get());
			}
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Alumno> buscarPorId(@PathVariable("id") Alumno idAlumno) {
		Optional<Alumno> optAlumno = service.buscaPorId(idAlumno.getIdAlumno());
		if (optAlumno == null) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok(optAlumno.get());
		}
	}
	
	@GetMapping("/dni/{paramDni}")
	public ResponseEntity<List<Alumno>> buscarPorDni(@PathVariable("paramDni") String dni ){
		List<Alumno> listAlumno = service.buscarPorDni(dni);
		if(CollectionUtils.isEmpty(listAlumno)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(listAlumno);
		}

	}

}
