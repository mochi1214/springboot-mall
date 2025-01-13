# 🛒 Spring Boot 電商網站 (Thymeleaf 前端模板)

本專案是一個基於 **Spring Boot** 後端 + **Thymeleaf** 前端模板的簡單電商網站，包含: **帳號功能、商品功能、訂單功能** 三大項目。

## 📌 主要功能
### 🔹 帳號功能
- **註冊** (`POST /users/register`)
- **登入** (`POST /users/login`)

### 🔹 商品功能
- **查看所有商品** (`GET /products`)
- **查看單個商品** (`GET /products/{productId}`)
- **新增商品** (`POST /products`)
- **更新商品** (`PUT /products/{productId}`)
- **刪除商品** (`DELETE /products/{productId}`)


### 🔹 訂單功能
- **查看用戶訂單** (`GET /users/{userId}/orders`)
- **創建訂單** (`POST /users/{userId}/orders`)


## 🛠 技術架構
- **Spring Boot** (後端框架)
- **Spring MVC** (處理 HTTP 請求)
- **Thymeleaf** (前端模板引擎)
- **Spring Data JDBC** (資料庫訪問)
- **H2 / MySQL** (資料庫)


## 🏗 專案結構
- **MVC 架構模式: Controller - Service - Dao 三層式架構** 


## 🌍 網頁介面
**頁面** **路徑**
登入頁	/home
註冊頁	/register
購物頁	/purchase
購物車	/cart


