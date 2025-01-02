package com.lila.springbootmall.service.impl;

import com.lila.springbootmall.dto.CartItem;
import com.lila.springbootmall.model.Product;
import com.lila.springbootmall.service.CartService;
import com.lila.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CartServiceImpl implements CartService {

    // 模擬的購物車存儲（可以改為存儲到 Session 或資料庫）
    private final Map<Integer, CartItem> cart = new HashMap<>();

    @Autowired
    private ProductService productService;

    @Override
    public void addItem(Integer productId, Integer quantity) {
        // 檢查購物車中是否已存在該商品
        CartItem item = cart.get(productId);

        if (item == null) {
            // 商品第一次加入購物車，從 ProductService 獲取商品信息
            Product product = productService.getProductById(productId);

            if (product != null) {
                item = new CartItem();
                item.setProductId(product.getProductId());
                item.setProductName(product.getProductName());
                item.setPrice(product.getPrice());
                item.setQuantity(quantity);
                cart.put(productId, item);
            } else {
                // 如果商品不存在，記錄錯誤或丟擲異常
                throw new IllegalArgumentException("商品不存在，無法添加到購物車");
            }
        } else {
            // 如果商品已存在，增加數量
            item.setQuantity(item.getQuantity() + quantity);
        }
    }

    @Override
    public List<CartItem> getCartItems() {
        return new ArrayList<>(cart.values());
    }

    @Override
    public Integer getCartItemCount() {
        return cart.values().stream().mapToInt(CartItem::getQuantity).sum();
    }
}

