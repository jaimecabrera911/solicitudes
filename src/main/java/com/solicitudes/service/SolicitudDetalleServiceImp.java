package com.solicitudes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solicitudes.entity.Solicitud;
import com.solicitudes.entity.SolicitudDetalle;
import com.solicitudes.repository.SolicitudDetalleRepository;

@Service
public class SolicitudDetalleServiceImp implements SolicitudDetalleService {

	@Autowired
	SolicitudDetalleRepository solicitudDetalleRepository;
	
	@Override
	public List<SolicitudDetalle> listarTodo() {
		// TODO Auto-generated method stub
		return solicitudDetalleRepository.findAll();
	}

	@Override
	public Optional<SolicitudDetalle> listarPorId(Integer id) {
		
		return solicitudDetalleRepository.findById(id);
	}

	@Override
	public List<SolicitudDetalle> buscarPorIdSolicitud(Solicitud solicitudesIdSolicitud) {
		
		return solicitudDetalleRepository.findBySolicitudesIdSolicitud(solicitudesIdSolicitud);
	}

}
