package com.solicitudes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solicitudes.entity.Solicitud;
import com.solicitudes.repository.SolicitudRepository;

@Service
public class SolicitudServiceImp implements SolicitudService {
	
	@Autowired
	SolicitudRepository solicitudRepository;

	@Override
	public List<Solicitud> listarTodo() {
		return solicitudRepository.findAll();
	}

	@Override
	public Optional<Solicitud> buscarPorId(Integer id) {
		return solicitudRepository.findById(id);
	}

	@Override
	public void guardar(Solicitud solicitud) {
		solicitudRepository.save(solicitud);	
	}

	@Override
	public List<Solicitud> buscarPorEstado(String estado) {
		// TODO Auto-generated method stub
		return solicitudRepository.findByEstado(estado);
	}
	
	

}
