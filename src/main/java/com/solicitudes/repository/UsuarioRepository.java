/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicitudes.repository;

import com.solicitudes.entity.Usuario;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DesarrolladorWeb6
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByEmail(String email);

}
