package com.solicitudes.service;

import java.util.List;
import java.util.Optional;

import com.solicitudes.entity.Solicitud;
import com.solicitudes.entity.SolicitudDetalle;

public interface SolicitudDetalleService {

	public List<SolicitudDetalle> listarTodo();

	public Optional<SolicitudDetalle> listarPorId(Integer id);
	
	public List<SolicitudDetalle> buscarPorIdSolicitud(Solicitud solicitudesIdSolicitud);
}
