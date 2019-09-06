package com.example.demo.service;

import com.example.demo.model.SysRole;
import com.example.demo.model.SysUser;

/**
 * @Author: 青菜
 * @Date: 2019/9/4 下午4:11
 * @Description:
 * @Version 1.0
 */
public interface SysUserService {

    /**
     * getUserByUsername
     * @param userName
     * @return
     */
    SysUser getUserByUsername(String userName);

    /**
     * getUserRoleInfo
     * @param userId
     * @return
     */
    SysRole getUserRoleInfo(String userId);

}
