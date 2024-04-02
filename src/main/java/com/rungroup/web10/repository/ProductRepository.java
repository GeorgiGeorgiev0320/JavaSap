package com.rungroup.web10.repository;

import com.rungroup.web10.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String url);
}
