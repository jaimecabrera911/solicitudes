package com.solicitudes.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solicitudes.entity.Solicitud;
import com.solicitudes.entity.SolicitudDetalle;
import com.solicitudes.entity.Usuario;
import com.solicitudes.service.SolicitudDetalleService;
import com.solicitudes.service.SolicitudService;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudController {

	@Autowired
	SolicitudService solicitudService;

	@Autowired
	HttpSession httpSession;

	@GetMapping("/")
	public String listarTodo(Model model) {
		List<Solicitud> lista = solicitudService.listarTodo();
		model.addAttribute("solicitudes", lista);
		return "views/solicitudes/lista";
	}

	@GetMapping("/{id}")
	public String verSolicitudPorId(@PathVariable int id, Model model) {
		Solicitud solicitud = solicitudService.buscarPorId(id).get();
		model.addAttribute("solicitud", solicitud);
		//System.out.println(solicitud.getSolicitudDetalleList().toString());
		List<SolicitudDetalle> detalleSolicitud = solicitud.getSolicitudDetalleList();
		//System.out.println(detalleSolicitud.toString());
		model.addAttribute("listaDetalleSolicitud", detalleSolicitud);
		return "views/solicitudes/detalle";
	}

	@GetMapping("/form")
	public String formulario(Solicitud solicitud) {
		System.out.println("Formulario");
		return "/views/solicitudes/form";
	}

	@PostMapping("/guardar")
	public String guardar(Solicitud solicitud, Usuario usuario) {
		//System.out.println("VACIO: "+usuario);
		solicitud.setEstado("EN PROCESO");
		Usuario _usuario = (Usuario) httpSession.getAttribute("usuarioLogin");
		//System.out.println("ID"+_usuario);
		usuario.setIdUsuario(_usuario.getIdUsuario());
		//System.out.println("DATOS: "+usuario);
		solicitud.setUsuariosIdUsuario(usuario);
		//System.out.println(solicitud);
		solicitudService.guardar(solicitud);
		return "redirect:/solicitudes/";
	}
	
	
	@GetMapping("/estado/{estado}")
	public String listarPorEstado(@PathVariable String estado, Model model) {
		System.out.println("Por estado");
		List<Solicitud> lista = solicitudService.buscarPorEstado(estado);
		System.out.println(lista.toString());
		model.addAttribute("solicitudes", lista);
		return "views/solicitudes/lista";
	}
}
