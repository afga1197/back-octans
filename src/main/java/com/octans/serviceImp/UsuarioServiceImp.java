package com.octans.serviceImp;

import java.util.List;
import com.octans.entity.Usuario;
import com.octans.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.octans.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public ResponseEntity<String> save(Usuario usuario) {
		boolean existe = findByName(usuario.getNombre());
		if (!existe) {
			usuarioRepository.save(usuario);
			return new ResponseEntity<String>("Se creo el usuario correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("El usuario ya existe en el sistema", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> update(Usuario usuario) {
		boolean existe = findUpdate(usuario.getNombre(), usuario.getId());
		if (!existe) {
			usuarioRepository.save(usuario);
			return new ResponseEntity<String>("Se actualizo el usuario correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(
					"El nombre de usuario que intenta usar ya se encuentra registrado en el sistema",
					HttpStatus.BAD_REQUEST);
		}
	}

	private boolean findUpdate(String nombre, int id) {
		try {
			Usuario buscado = usuarioRepository.findByName(nombre);
			if (buscado.equals(null)) {
				throw new Exception();
			} else {
				if (id == buscado.getId()) {
					return false;
				} else {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
	}

	private boolean findByName(String nombre) {
		try {
			Usuario buscado = usuarioRepository.findByName(nombre);
			if (buscado.equals(null)) {
				throw new Exception();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ResponseEntity<String> delete(int id) {
		usuarioRepository.deleteById(id);
		return new ResponseEntity<String>("Se elimino el usuario correctamente", HttpStatus.OK);
	}

}