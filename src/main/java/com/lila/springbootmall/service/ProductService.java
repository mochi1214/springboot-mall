package com.lila.springbootmall.service;

import com.lila.springbootmall.category.ProductCategory;
import com.lila.springbootmall.dto.ProductQueryParams;
import com.lila.springbootmall.dto.ProductRequest;
import com.lila.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
