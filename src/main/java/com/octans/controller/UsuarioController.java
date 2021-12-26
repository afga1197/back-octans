package com.octans.controller;

import java.util.List;
import com.octans.entity.Usuario;
import com.octans.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	@RequestMapping("/listUsers")
	public ResponseEntity<List<Usuario>> list() {
		return new ResponseEntity<List<Usuario>>(usuarioService.findAll(), HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping("/saveUser")
	public ResponseEntity<String> save(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@PutMapping
	@RequestMapping("/updateUser")
	public ResponseEntity<String> update(@RequestBody Usuario usuario) {
		return usuarioService.update(usuario);
	}

	@DeleteMapping(value = "/{id}")
	@RequestMapping("/deleteUser")
	public ResponseEntity<String> delete(@RequestParam("id") int id) {
		return usuarioService.delete(id);
	}

}