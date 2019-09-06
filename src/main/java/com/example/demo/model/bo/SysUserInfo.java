package com.example.demo.model.bo;

import com.example.demo.model.SysRole;
import com.example.demo.model.SysUser;
import lombok.Data;

/**
 * @Author: 青菜
 * @Date: 2019/9/4 下午4:35
 * @Description:
 * @Version 1.0
 */
@Data
public class SysUserInfo extends SysUser {

    private SysRole sysRole;

}
