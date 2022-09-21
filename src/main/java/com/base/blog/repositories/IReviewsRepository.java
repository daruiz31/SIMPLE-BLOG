package com.base.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.blog.entities.Review;

@Repository
public interface IReviewsRepository extends JpaRepository<Review, Long> {

}
