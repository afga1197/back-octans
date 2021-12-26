package com.octans.controller;

import java.util.List;
import com.octans.entity.Rol;
import com.octans.service.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public class RolController {

	@Autowired
	private RolService rolServie;

	@GetMapping
	@RequestMapping("/listRol")
	public ResponseEntity<List<Rol>> list() {
		return new ResponseEntity<List<Rol>>(rolServie.findAll(), HttpStatus.OK);
	}

}