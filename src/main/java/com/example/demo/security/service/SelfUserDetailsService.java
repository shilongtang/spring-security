package com.example.demo.security.service;

import com.example.demo.model.SelfUserDetails;
import com.example.demo.model.SysRole;
import com.example.demo.model.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 青菜
 * @Date: 2019/8/30 下午6:20
 * @Description:
 * @Version 1.0
 */
@Service
public class SelfUserDetailsService implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SelfUserDetails userInfo = new SelfUserDetails();
        userInfo.setUsername(userName);
        SysUser sysUser = sysUserService.getUserByUsername(userName);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        userInfo.setPassword(sysUser.getPassword());
        SysRole sysRole = sysUserService.getUserRoleInfo(sysUser.getUserId());
        if (sysRole == null) {
            throw new UsernameNotFoundException("用户未分配权限！");
        }
        if (sysRole.getState() == 0) {
            throw new UsernameNotFoundException("用户权限失效！");
        }
        userInfo.setAuthorities(getAuthorities(sysRole.getName()));
        return userInfo;
    }
    private Set<GrantedAuthority> getAuthorities(String role) {
        Set<GrantedAuthority> authoritiesSet = new HashSet();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
        authoritiesSet.add(grantedAuthority);
        return authoritiesSet;
    }

}
