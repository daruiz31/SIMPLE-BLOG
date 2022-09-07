package com.base.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.blog.entities.User;

@Repository
public interface IUsersRepository extends JpaRepository<User, Long> {

}
