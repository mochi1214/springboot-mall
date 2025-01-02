package com.lila.springbootmall.controller.frontend;

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
        List<Map<String, Object>> products = List.of(
                Map.of(
                        "productName", "Tesla",
                        "imageUrl", "https://cdn.pixabay.com/photo/2021/01/15/16/49/tesla-5919764_1280.jpg"
                ),
                Map.of(
                        "productName", "Benz",
                        "imageUrl", "https://cdn.pixabay.com/photo/2017/03/27/14/56/auto-2179220_1280.jpg"
                ),
                Map.of(
                        "productName", "BMW",
                        "imageUrl", "https://cdn.pixabay.com/photo/2018/02/21/03/15/bmw-m4-3169357_1280.jpg"
                ),
                Map.of(
                        "productName", "Toyota",
                        "imageUrl", "https://cdn.pixabay.com/photo/2014/05/18/19/13/toyota-347288_1280.jpg"
                ),
                Map.of(
                        "productName", "好吃又鮮甜的蘋果橘子",
                        "imageUrl", "https://cdn.pixabay.com/photo/2021/07/30/04/17/orange-6508617_1280.jpg"
                ),
                Map.of(
                        "productName", "蘋果（日本北海道）",
                        "imageUrl", "https://cdn.pixabay.com/photo/2017/09/26/13/42/apple-2788662_1280.jpg"
                ),
                Map.of(
                        "productName", "蘋果（澳洲）",
                        "imageUrl", "https://cdn.pixabay.com/photo/2016/11/30/15/00/apples-1872997_1280.jpg"
                )
        );

        // 將商品數據傳遞給模板
        model.addAttribute("products", products);
        return "purchase"; // 返回商品頁面的模板名稱
    }

}
