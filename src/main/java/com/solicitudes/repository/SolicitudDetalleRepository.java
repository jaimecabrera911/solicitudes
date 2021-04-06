package com.solicitudes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solicitudes.entity.Solicitud;
import com.solicitudes.entity.SolicitudDetalle;

public interface SolicitudDetalleRepository extends JpaRepository<SolicitudDetalle, Integer> {

	public List<SolicitudDetalle> findBySolicitudesIdSolicitud(Solicitud solicitudesIdSolicitud);

}
