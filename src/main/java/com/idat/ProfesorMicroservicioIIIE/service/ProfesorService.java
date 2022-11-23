package com.idat.ProfesorMicroservicioIIIE.service;

import java.util.List;

import com.idat.ProfesorMicroservicioIIIE.dto.ProfesorDTO;

public interface ProfesorService {
	List<ProfesorDTO> listar();
	ProfesorDTO obtenerId(Integer id);
	void guardar(ProfesorDTO profesor);
	void eliminar(Integer id);
	void actualizar(ProfesorDTO profesor);
}
