package com.lila.springbootmall.service.impl;

import com.lila.springbootmall.category.ProductCategory;
import com.lila.springbootmall.dao.ProductDao;
import com.lila.springbootmall.dto.ProductRequest;
import com.lila.springbootmall.model.Product;
import com.lila.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProducts(ProductCategory category, String search) {
        return productDao.getAllProducts(category, search);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProduct(productId);
    }
}
