package com.octans.repository;

import com.octans.entity.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface UsuarioRepository
		extends CrudRepository<Usuario, Integer>, JpaSpecificationExecutor<Usuario>, JpaRepository<Usuario, Integer> {

	@Query(value = "SELECT m FROM Usuario m WHERE m.nombre = :nombre")
	Usuario findByName(@Param("nombre") String nombre);

}