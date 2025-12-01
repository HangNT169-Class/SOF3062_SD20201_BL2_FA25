package com.poly.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    // Co 2 quyen:
    // admin: se duoc truy cap vao duong dan: "/api/admin/*"
    // user:se duoc truy cap vao duong dan: "/api/user/*"
    // /public => Dang nhap hay k dang nhap deu truy cap duoc
    // cac dang dan con lai thi bat buoc phai dang nhap
    // authen: Check tai khoang/mat khau co ton tai trong he thong hay khong ? => 401: Chua dang nhap
    // author: Check cai tai khoan vua dang nhap xem thuoc role gi ? => 403: Cam quyen

    @GetMapping("public")
    public String testPublic() {
        return "Day la trang tat ca moi nguoi deu truy cap duoc";
    }

    @GetMapping("api/admin/test")
    public String testAdmin() {
        return "Day la trang admin => Chi admin moi duoc quyen truy cap";
    }

    @GetMapping("api/user/test")
    public String testUser() {
        return "Day la trang user";
    }
}
