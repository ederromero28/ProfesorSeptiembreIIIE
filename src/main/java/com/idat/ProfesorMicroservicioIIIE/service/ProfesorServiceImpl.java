package com.idat.ProfesorMicroservicioIIIE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ProfesorMicroservicioIIIE.dto.ProfesorDTO;
import com.idat.ProfesorMicroservicioIIIE.model.Profesor;
import com.idat.ProfesorMicroservicioIIIE.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	private ProfesorRepository repository;

	@Override
	public List<ProfesorDTO> listar() {
		// TODO Auto-generated method stub
		List<ProfesorDTO> listadto = new ArrayList<>();
		ProfesorDTO dto = null;
		
		for(Profesor profesor : repository.findAll()) {
			dto = new ProfesorDTO();
			dto.setApe(profesor.getApellido());
			dto.setNom(profesor.getNombre());
			dto.setCur(profesor.getCurso());		
			dto.setCod(profesor.getIdProfesor());
			listadto.add(dto);
		}
		return listadto;
	}

	@Override
	public ProfesorDTO obtenerId(Integer id) {
		// TODO Auto-generated method stub
		Profesor profesor = repository.findById(id).orElse(null);
		ProfesorDTO dto = new ProfesorDTO();
		dto.setApe(profesor.getApellido());
		dto.setNom(profesor.getNombre());
		dto.setCur(profesor.getCurso());
		dto.setCod(profesor.getIdProfesor());
		
		return dto;
	}

	@Override
	public void guardar(ProfesorDTO profesor) {
		// TODO Auto-generated method stub
		Profesor pro = new Profesor();
        pro.setApellido(profesor.getApe());
        pro.setNombre(profesor.getNom());
        pro.setCurso(profesor.getCur());
        pro.setIdProfesor(profesor.getCod());
        
        repository.save(pro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void actualizar(ProfesorDTO profesor) {
		// TODO Auto-generated method stub
        Profesor pro = new Profesor();
        pro.setApellido(profesor.getApe());
        pro.setNombre(profesor.getNom());
        pro.setCurso(profesor.getCur());
        pro.setIdProfesor(profesor.getCod());
        
        repository.saveAndFlush(pro);
	}

}
