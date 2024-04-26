package com.rungroup.web10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rungroup.web10.models.Product;
import com.rungroup.web10.models.Review;
import com.rungroup.web10.models.UserEntity;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProduct(Product product);

    List<Review> findByUser(UserEntity user);

    List<Review> findByRatingGreaterThan(int rating);

    List<Review> findByRatingLessThan(int rating);

    List<Review> findByRatingBetween(int startRating, int endRating);
}

