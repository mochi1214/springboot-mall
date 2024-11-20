package com.lila.springbootmall.dao;

import com.lila.springbootmall.dto.ProductRequest;
import com.lila.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
