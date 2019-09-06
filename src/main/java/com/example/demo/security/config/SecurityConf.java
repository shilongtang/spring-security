package com.example.demo.security.config;

import com.example.demo.security.service.SelfUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @Author: 青菜
 * @Date: 2019/9/4 下午4:51
 * @Description: WebSecurityConfigurerAdapter：登录拦截全局配置
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    /**
     *  未登陆时返回 JSON 格式的数据给前端（否则为 html）
     */
    @Autowired
    AuthenticationEntryPointConfig authenticationEntryPoint;

    /**
     *  登录成功返回的 JSON 格式数据给前端（否则为 html）
     */
    @Autowired
    AuthenticationSuccessHandlerConfig authenticationSuccessHandler;

    /**
     * 登录失败返回的 JSON 格式数据给前端（否则为 html）
     */
    @Autowired
    AuthenticationFailureHandlerConfig authenticationFailureHandler;

    /**
     * 注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）
     */
    @Autowired
    LogoutSuccessHandlerConfig logoutSuccessHandler;

    /**
     * 无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）
     */
    @Autowired
    AccessDeniedHandlerConfig accessDeniedHandler;

    @Autowired
    LogoutHandlerConfig logoutHandler;

    /**
     * 自定义安全认证
     */
    @Autowired
    SelfAuthenticationProvider provider;

    @Autowired
    SelfUserDetailsService selfUserDetailsService;


    @Autowired
    AuthenticationFailHandlerConfig myAuthenticationFailHander;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
       // super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/role/**").hasRole("admin")
                // 这就表示 /index这个页面不需要权限认证，所有人都可以访问
               /* .antMatchers("/test/**").permitAll()
                .antMatchers(HttpMethod.POST,"/user/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/user/").hasRole("USER")
                .antMatchers("/role/**").hasRole("admin")
                .anyRequest().authenticated()*/
                .anyRequest().access("@rbacService.hasPermission(request,authentication)")
                //.anyRequest().access("")
                // 其他 url 需要身份认证
                //.authenticated()
                .and()
                // login 相关
                // 开启登录
                .formLogin()
                // 登录成功
                .successHandler(authenticationSuccessHandler)
                // 登录失败
                .failureHandler(authenticationFailureHandler)
                .permitAll()
                .and()
                // logout 相关
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .addLogoutHandler(logoutHandler)
                .permitAll().and()
                .rememberMe()
                .rememberMeParameter("remember-me").userDetailsService(selfUserDetailsService)
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(6000);
                // 无权访问 JSON 格式的数据
                http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面


    }
}
