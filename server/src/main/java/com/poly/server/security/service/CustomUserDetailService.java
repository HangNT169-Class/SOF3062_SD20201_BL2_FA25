package com.poly.server.security.service;

import com.poly.server.entity.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    // Spring security => UserDetailService:
    // SELECT * FROM user:
    // username & password
    // password: Bycy...

    @Autowired
    private PasswordEncoder passwordEncoder; // Ma hoa mat khau: Bycry..

    // fake data
    private List<TaiKhoan> listTaiKhoan = List.of(
            // liet ke cac phan tu
            new TaiKhoan("user", "123456", "USER"),
            new TaiKhoan("admin", "1234567", "ADMIN")
    );


    // phuong thuc dung de lay xac thuc thong tin cua nguoi dung => Authen
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // neu trong sql => goi repo de tim kiem
        // in memory
        // tim kiem: Co the thay bang for
        TaiKhoan tk = listTaiKhoan.stream()
                .filter(t -> t.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Tai khoan khong ton tai"));
        // Return 1 user detail: username, password, role
        return User.withUsername(tk.getUsername())
                .password(passwordEncoder.encode(tk.getPassword()))
                .roles(tk.getRole())
                .build();
    }
}
