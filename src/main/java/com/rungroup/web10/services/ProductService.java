package com.rungroup.web10.services;

import com.rungroup.web10.dto.ProductDto;
import com.rungroup.web10.models.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAllProducts();
    Product saveProduct(ProductDto productDto);
    ProductDto findProductById(long productId);

    void updateProduct(ProductDto product);
}
