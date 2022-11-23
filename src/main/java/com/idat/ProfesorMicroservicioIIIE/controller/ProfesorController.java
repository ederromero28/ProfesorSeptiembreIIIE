package com.idat.ProfesorMicroservicioIIIE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.ProfesorMicroservicioIIIE.dto.ProfesorDTO;
import com.idat.ProfesorMicroservicioIIIE.service.ProfesorService;

@Controller
@RequestMapping("/api/profesor/v2")
public class ProfesorController {
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/listar")
	public @ResponseBody List<ProfesorDTO> listar(){
		return profesorService.listar();
	}
	
	@GetMapping("/listar/{id}")
	public @ResponseBody ProfesorDTO obtenerId(@PathVariable Integer id) {
		return profesorService.obtenerId(id);
	}
	
	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody ProfesorDTO dto) {
		profesorService.guardar(dto);
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody void actualizar(@RequestBody ProfesorDTO dto) {
		profesorService.actualizar(dto);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		profesorService.eliminar(id);
	}

}
