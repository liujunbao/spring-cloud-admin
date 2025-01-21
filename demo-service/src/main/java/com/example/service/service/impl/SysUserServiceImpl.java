package com.example.service.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.service.dto.LoginDTO;
import com.example.service.entity.SysUser;
import com.example.service.mapper.SysUserMapper;
import com.example.service.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {
    private final SysUserMapper userMapper;

    @Override
    public String login(LoginDTO loginDTO) {
        // 查询用户
        SysUser user = userMapper.selectOne(
            new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, loginDTO.getUsername())
        );
        
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        
        // 验证密码
        String encodedPassword = DigestUtils.md5DigestAsHex(loginDTO.getPassword().getBytes());
        if (!encodedPassword.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        
        // 验证状态
        if (user.getStatus() != 1) {
            throw new RuntimeException("账号已被禁用");
        }
        
        // 登录
        StpUtil.login(user.getId());
        return StpUtil.getTokenValue();
    }

    @Override
    public SysUser getInfo() {
        Long userId = StpUtil.getLoginIdAsLong();
        return userMapper.selectById(userId);
    }

    @Override
    public void logout() {
        StpUtil.logout();
    }
} 