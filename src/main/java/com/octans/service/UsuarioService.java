package com.octans.service;

import java.util.List;
import com.octans.entity.Usuario;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

	List<Usuario> findAll();
	ResponseEntity<String> save(Usuario usuario);
	ResponseEntity<String> update(Usuario usuario);
	ResponseEntity<String> delete(int id);

}