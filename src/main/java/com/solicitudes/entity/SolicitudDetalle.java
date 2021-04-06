/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicitudes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DesarrolladorWeb6
 */
@Entity
@Table(name = "solicitud_detalle")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SolicitudDetalle.findAll", query = "SELECT s FROM SolicitudDetalle s"),
		@NamedQuery(name = "SolicitudDetalle.findByIdSolicitudDetalles", query = "SELECT s FROM SolicitudDetalle s WHERE s.idSolicitudDetalles = :idSolicitudDetalles"),
		@NamedQuery(name = "SolicitudDetalle.findByDetalle", query = "SELECT s FROM SolicitudDetalle s WHERE s.detalle = :detalle") })
public class SolicitudDetalle implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_solicitud_detalles")
	private Integer idSolicitudDetalles;
	@Column(name = "detalle")
	private String detalle;
	@Column(name = "estado")
	private String estado;
	@JoinColumn(name = "solicitudes_id_solicitud", referencedColumnName = "id_solicitud")
	@ManyToOne(optional = false)
	@JsonIgnore
	private Solicitud solicitudesIdSolicitud;
	@JoinColumn(name = "usuarios_id_usuario", referencedColumnName = "id_usuario")
	@ManyToOne(optional = false)
	private Usuario usuariosIdUsuario;

	public SolicitudDetalle() {
	}

	public SolicitudDetalle(Integer idSolicitudDetalles) {
		this.idSolicitudDetalles = idSolicitudDetalles;
	}

	public Integer getIdSolicitudDetalles() {
		return idSolicitudDetalles;
	}

	public void setIdSolicitudDetalles(Integer idSolicitudDetalles) {
		this.idSolicitudDetalles = idSolicitudDetalles;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Solicitud getSolicitudesIdSolicitud() {
		return solicitudesIdSolicitud;
	}

	public void setSolicitudesIdSolicitud(Solicitud solicitudesIdSolicitud) {
		this.solicitudesIdSolicitud = solicitudesIdSolicitud;
	}

	public Usuario getUsuariosIdUsuario() {
		return usuariosIdUsuario;
	}

	public void setUsuariosIdUsuario(Usuario usuariosIdUsuario) {
		this.usuariosIdUsuario = usuariosIdUsuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idSolicitudDetalles != null ? idSolicitudDetalles.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SolicitudDetalle)) {
			return false;
		}
		SolicitudDetalle other = (SolicitudDetalle) object;
		if ((this.idSolicitudDetalles == null && other.idSolicitudDetalles != null)
				|| (this.idSolicitudDetalles != null && !this.idSolicitudDetalles.equals(other.idSolicitudDetalles))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SolicitudDetalle [idSolicitudDetalles=" + idSolicitudDetalles + ", detalle=" + detalle + ", estado="
				+ estado + ", solicitudesIdSolicitud=" + solicitudesIdSolicitud + ", usuariosIdUsuario="
				+ usuariosIdUsuario + "]";
	}

}
