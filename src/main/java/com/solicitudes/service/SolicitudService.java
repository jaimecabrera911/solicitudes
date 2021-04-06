package com.solicitudes.service;

import java.util.List;
import java.util.Optional;

import com.solicitudes.entity.Solicitud;

public interface SolicitudService {

	public List<Solicitud> listarTodo();

	public Optional<Solicitud> buscarPorId(Integer id);
	
	public void guardar(Solicitud solicitud);
	
	public List<Solicitud> buscarPorEstado(String estado);

	
}
