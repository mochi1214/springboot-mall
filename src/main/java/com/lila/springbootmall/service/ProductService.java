package com.lila.springbootmall.service;

import com.lila.springbootmall.dto.ProductRequest;
import com.lila.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
