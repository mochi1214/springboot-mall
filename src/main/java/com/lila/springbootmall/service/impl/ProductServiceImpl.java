package com.lila.springbootmall.service.impl;

import com.lila.springbootmall.dao.ProductDao;
import com.lila.springbootmall.dto.ProductRequest;
import com.lila.springbootmall.model.Product;
import com.lila.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
