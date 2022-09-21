package com.base.blog.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.base.blog.entities.Review;

@Repository
public interface IReviewsRepository extends JpaRepository<Review, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM reviews INNER JOIN users ON reviews.iduser = users.idusers INNER JOIN roles ON users.idrol = roles.idroles WHERE roles.role = :role")
	Optional<List<Review>> findAllByRole(@Param("role") String role);

}
