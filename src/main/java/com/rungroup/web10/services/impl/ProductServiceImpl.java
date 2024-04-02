package com.rungroup.web10.services.impl;

import com.rungroup.web10.dto.ProductDto;
import com.rungroup.web10.models.Product;
import com.rungroup.web10.repository.ProductRepository;
import com.rungroup.web10.services.ProductService;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return  products.stream().map((product) -> mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public Product saveProduct(ProductDto productDto) {
        Product product = mapToProduct(productDto);
        return productRepository.save(product);
    }

    private Product mapToProduct(ProductDto productDto) {
        Product product = Product.builder()
                .id(productDto.getId())
                .productId(productDto.getId())
                .description(productDto.getDescription())
                .name(productDto.getName())
                .ImageUrl(productDto.getImageUrl())
                .price(productDto.getPrice())
                .createdOn(productDto.getCreatedOn())
                .quantity(productDto.getQuantity())
                .updatedOn(productDto.getUpdatedOn())
                .build();
        return product;
    }

    @Override
    public ProductDto findProductById(long productId) {
        Product product = productRepository.findById(productId).get();
        return mapToProductDto(product);
    }

    @Override
    public void updateProduct(ProductDto product) {
        Product product1 = productRepository.findById(product.getId()).get();
        product1.setName(product.getName());
        product1.setUpdatedOn(LocalDateTime.now());
        product1.setDescription(product.getDescription());
        product1.setQuantity(product.getQuantity());
        product1.setPrice(product.getPrice());
        product1.setImageUrl(product.getImageUrl());
        product1.setProductId(product1.getId());


        productRepository.save(product1);
    }


    private ProductDto mapToProductDto(Product product) {
        ProductDto productDto = ProductDto.builder()
                .id(product.getId())
                .productId(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .ImageUrl(product.getImageUrl())
                .price(product.getPrice())
                .createdOn(product.getCreatedOn())
                .quantity(product.getQuantity())
                .updatedOn(product.getUpdatedOn())
                .build();
        return productDto;
    }
}
