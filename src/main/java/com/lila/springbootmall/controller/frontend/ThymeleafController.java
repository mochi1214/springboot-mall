package com.lila.springbootmall.controller.frontend;

import com.lila.springbootmall.dto.ProductQueryParams;
import com.lila.springbootmall.model.Product;
import com.lila.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.lila.springbootmall.dto.UserLoginRequest;
import com.lila.springbootmall.dto.UserRegisterRequest;
import com.lila.springbootmall.model.User;
import com.lila.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterRequest userRegisterRequest,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "輸入的資料格式不正確");
            return "register";
        }

        try {
            userService.register(userRegisterRequest);
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", "註冊失敗：" + e.getMessage());
            return "register";
        }
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginRequest userLoginRequest,
                        BindingResult bindingResult,
                        Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "輸入的電子郵件或密碼格式不正確");
            return "index";
        }

        try {
            User user = userService.login(userLoginRequest);
            model.addAttribute("user", user);
            return "redirect:/purchase"; // 登入成功後跳轉到購買頁面
        } catch (Exception e) {
            model.addAttribute("error", "登入失敗：" + e.getMessage());
            return "index";
        }
    }

    @GetMapping("/purchase")
    public String getProducts(Model model) {
        // 初始化查詢參數並設置默認值
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setOrderBy("created_date"); // 默認按創建日期排序
        productQueryParams.setSort("desc"); // 默認降序
        productQueryParams.setLimit(10); // 默認每頁顯示 10 條數據
        productQueryParams.setOffset(0); // 默認從第一條數據開始

        // 從資料庫獲取商品數據
        List<Product> products = productService.getAllProducts(productQueryParams);

        // 將商品數據傳遞給模板
        model.addAttribute("products", products);
        return "purchase";
    }

}
