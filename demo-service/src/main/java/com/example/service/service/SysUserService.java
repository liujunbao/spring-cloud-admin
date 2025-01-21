package com.example.service.service;

import com.example.service.dto.LoginDTO;
import com.example.service.entity.SysUser;

public interface SysUserService {
    String login(LoginDTO loginDTO);
    SysUser getInfo();
    void logout();
} 