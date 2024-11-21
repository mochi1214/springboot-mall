package com.lila.springbootmall.dao;

import com.lila.springbootmall.dto.ProductRequest;
import com.lila.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
