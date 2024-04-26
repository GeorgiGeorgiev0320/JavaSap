package com.rungroup.web10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rungroup.web10.models.Product;
import com.rungroup.web10.models.ShoppingCart;
import com.rungroup.web10.models.UserEntity;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findByUser(UserEntity user);

    List<ShoppingCart> findByProduct(Product product);

    ShoppingCart findByUserAndProduct(UserEntity user, Product product);

    ShoppingCart findByUserAndProductId(UserEntity user, Long productId);

    List<ShoppingCart> findByUserIdAndProductId(Long userId, Long productId);

    List<ShoppingCart> findByUserAndQuantityGreaterThan(UserEntity user, int quantity);

    List<ShoppingCart> findByUserAndQuantityLessThan(UserEntity user, int quantity);

    List<ShoppingCart> findByUserAndQuantityBetween(UserEntity user, int startQuantity, int endQuantity);
}
