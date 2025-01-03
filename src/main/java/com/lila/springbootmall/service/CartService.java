package com.lila.springbootmall.service;

import com.lila.springbootmall.dto.CartItem;

import java.util.List;

public interface CartService {

    void addItem(Integer productId, Integer quantity);

    List<CartItem> getCartItems();

    Integer getCartItemCount();

    void removeItem(Integer productId);

    void clearCart();

}
