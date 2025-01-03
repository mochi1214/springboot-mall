package com.lila.springbootmall.service.impl;

import com.lila.springbootmall.dto.CartItem;
import com.lila.springbootmall.model.Product;
import com.lila.springbootmall.service.CartService;
import com.lila.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CartServiceImpl implements CartService {

    private final Map<Integer, CartItem> cart = new HashMap<>();

    @Autowired
    private ProductService productService;

    @Override
    public void addItem(Integer productId, Integer quantity) {
        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException("商品不存在！");
        }

        CartItem item = cart.get(productId);
        if (item == null) {
            item = new CartItem();
            item.setProductId(productId);
            item.setProductName(product.getProductName());
            item.setPrice(product.getPrice());
            item.setQuantity(quantity);
            cart.put(productId, item);
        } else {
            item.setQuantity(item.getQuantity() + quantity);
        }
    }

    @Override
    public List<CartItem> getCartItems() {
        return new ArrayList<>(cart.values());
    }

    @Override
    public Integer getCartItemCount() {
        return cart.values().stream()
                .mapToInt(item -> item.getQuantity() != null ? item.getQuantity() : 0)
                .sum();
    }

    @Override
    public void removeItem(Integer productId) {
        cart.remove(productId);
    }

    @Override
    public void clearCart() {
        cart.clear();
    }
}

