/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicitudes.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author DesarrolladorWeb6
 */
@Entity
@Table(name = "solicitudes")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
		@NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud"),
		@NamedQuery(name = "Solicitud.findByCreada", query = "SELECT s FROM Solicitud s WHERE s.creada = :creada"),
		@NamedQuery(name = "Solicitud.findByActualizada", query = "SELECT s FROM Solicitud s WHERE s.actualizada = :actualizada"),
		@NamedQuery(name = "Solicitud.findByDetalle", query = "SELECT s FROM Solicitud s WHERE s.detalle = :detalle"),
		@NamedQuery(name = "Solicitud.findByEstado", query = "SELECT s FROM Solicitud s WHERE s.estado = :estado") })
public class Solicitud implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_solicitud")
	private Integer idSolicitud;
	@Column(name = "creada")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date creada;
	@Column(name = "actualizada")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date actualizada;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "detalle")
	private String detalle;
	@Column(name = "estado")
	private String estado;
	@JoinColumn(name = "usuarios_id_usuario", referencedColumnName = "id_usuario")
	@ManyToOne(optional = false)
	private Usuario usuariosIdUsuario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudesIdSolicitud")
	private List<SolicitudDetalle> solicitudDetalleList;

	public Solicitud() {
	}

	public Solicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Date getCreada() {
		return creada;
	}

	public void setCreada(Date creada) {
		this.creada = creada;
	}

	public Date getActualizada() {
		return actualizada;
	}

	public void setActualizada(Date actualizada) {
		this.actualizada = actualizada;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@XmlTransient
	public List<SolicitudDetalle> getSolicitudDetalleList() {
		return solicitudDetalleList;
	}

	public void setSolicitudDetalleList(List<SolicitudDetalle> solicitudDetalleList) {
		this.solicitudDetalleList = solicitudDetalleList;
	}

	public Usuario getUsuariosIdUsuario() {
		return usuariosIdUsuario;
	}

	public void setUsuariosIdUsuario(Usuario usuariosIdUsuario) {
		this.usuariosIdUsuario = usuariosIdUsuario;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Solicitud)) {
			return false;
		}
		Solicitud other = (Solicitud) object;
		if ((this.idSolicitud == null && other.idSolicitud != null)
				|| (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Solicitud [idSolicitud=" + idSolicitud + ", creada=" + creada + ", actualizada=" + actualizada
				+ ", descripcion=" + descripcion + ", detalle=" + detalle + ", estado=" + estado
				+ ", usuariosIdUsuario=" + usuariosIdUsuario + "]";
	}

	

}
