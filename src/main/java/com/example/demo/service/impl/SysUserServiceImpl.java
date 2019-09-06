package com.example.demo.service.impl;

import com.example.demo.mapper.SysUserMapper;
import com.example.demo.model.SysRole;
import com.example.demo.model.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 青菜
 * @Date: 2019/9/4 下午4:11
 * @Description:
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByUsername(String userName) {
        return sysUserMapper.getUserByUsername(userName);
    }

    @Override
    public SysRole getUserRoleInfo(String userId) {
        return sysUserMapper.getUserRoleInfo(userId);
    }
}
