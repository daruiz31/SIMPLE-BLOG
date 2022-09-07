package com.base.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.blog.entities.Rol;

@Repository
public interface IRolesRepository extends JpaRepository<Rol, Long> {

}
