package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;
import com.util.Constantes;

@RestController
@RequestMapping("/rest/medicamento")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento> buscarPorId(@PathVariable("paramId") int idMedicamento){
		Optional<Medicamento> optMedicamento = service.buscarPorId(idMedicamento);
		if(optMedicamento == null) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(optMedicamento.get());
		}
	}
	
	@GetMapping("/nombre/{param_nombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscarPorNombre(@PathVariable("param_nombre") String nombre ){
		List<Medicamento> lista = service.buscarPorNombre("%" +nombre+ "%");
		if(CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/stock/{param_stock}")
	@ResponseBody 
	public ResponseEntity<List<Medicamento>> buscarPorStock(@PathVariable("param_stock") int stock ){
		List<Medicamento> lista = service.buscarPorStock(stock);
		if(CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listadoMedicamento(){
		List<Medicamento> lista = service.listadoMedicamentos();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object> > registrarMedicamento(@RequestBody Medicamento obj){
		Map<String, Object > salida = new HashMap<>();
		Medicamento objSalida;
		try {
			objSalida = service.registroMedicamento(obj);
			if(objSalida==null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		
		return ResponseEntity.ok(salida);//salida
	}
}
