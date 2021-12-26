package com.octans.repository;

import com.octans.entity.Rol;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface RolRepository
		extends CrudRepository<Rol, Integer>, JpaSpecificationExecutor<Rol>, JpaRepository<Rol, Integer> {

}