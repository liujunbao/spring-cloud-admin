package com.example.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.service.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
} 