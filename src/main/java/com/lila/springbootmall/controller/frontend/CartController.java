package com.lila.springbootmall.controller.frontend;

import com.lila.springbootmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    // 新增商品到購物車
    @PostMapping("/add/{productId}")
    public ResponseEntity<String> addItemToCart(
            @PathVariable Integer productId,
            @RequestParam Integer quantity) {
        try {
            cartService.addItem(productId, quantity);
            return ResponseEntity.ok("商品已成功加入購物車，當前總數: " + cartService.getCartItemCount());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 移除購物車中的商品
    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable Integer productId) {
        cartService.removeItem(productId);
        return ResponseEntity.ok("商品已成功從購物車中移除");
    }

    // 清空購物車
    @PostMapping("/cart/clear")
    public RedirectView clearCart(RedirectAttributes redirectAttributes) {
        cartService.clearCart();
        redirectAttributes.addFlashAttribute("message", "購物車已清空");
        return new RedirectView("/cart"); // 使用 RedirectView 來處理 Thymeleaf 的 redirect 問題
    }

}

