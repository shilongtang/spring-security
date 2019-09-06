package com.example.demo.mapper;

import com.example.demo.model.SysRole;
import com.example.demo.model.SysUser;
import org.springframework.stereotype.Component;

/**
 * @Author: 青菜
 * @Date: 2019/9/3 下午8:44
 * @Description:
 * @Version 1.0
 */
@Component
public interface SysUserMapper {

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
