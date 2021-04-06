package com.solicitudes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solicitudes.entity.Usuario;
import com.solicitudes.service.UsuarioService;

@Controller
@RequestMapping
public class LoginController {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping
	public String index(Usuario usuario) {
		return "index";
	}

	@PostMapping("/login")
	public String login(Usuario usuario, HttpSession httpSession) {
		usuario = usuarioService.buscarPorEmail(usuario.getEmail());
		httpSession.setAttribute("usuarioLogin", usuario);
		System.out.println(httpSession.getAttribute("usuarioLogin"));
		return "redirect:/solicitudes/";
	}

}
