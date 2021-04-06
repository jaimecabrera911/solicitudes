package com.solicitudes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solicitudes.entity.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
	
	public List<Solicitud> findByEstado(String estado);
}
