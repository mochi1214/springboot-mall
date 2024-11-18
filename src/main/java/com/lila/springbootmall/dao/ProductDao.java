package com.lila.springbootmall.dao;

import com.lila.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
