package com.octans.serviceImp;

import java.util.List;
import com.octans.entity.Rol;
import com.octans.service.RolService;
import com.octans.repository.RolRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RolServiceImp implements RolService {

	@Autowired
	private RolRepository rolRepository;

	@Override
	public List<Rol> findAll() {
		return rolRepository.findAll();
	}

}