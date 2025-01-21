package com.example.service.controller;

import com.example.service.common.Result;
import com.example.service.dto.LoginDTO;
import com.example.service.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SysUserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDTO loginDTO) {
        String token = userService.login(loginDTO);
        return Result.success(token);
    }

    @GetMapping("/info")
    public Result<?> getInfo() {
        return Result.success(userService.getInfo());
    }

    @PostMapping("/logout")
    public Result<?> logout() {
        userService.logout();
        return Result.success(null);
    }
} 