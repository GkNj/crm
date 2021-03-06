package com.nuc.sw.crm.config;

import com.nuc.sw.crm.handler.CustomAccessDeniedHandler;
import com.nuc.sw.crm.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 杨晓辉 2018-08-30 15:52
 * 权限管理配置
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserServiceImpl userService;


    /**
     * Override this method to configure the {@link HttpSecurity}. Typically subclasses
     * should not invoke this method by calling super as it may override their
     * configuration. The default configuration is:
     *
     * <pre>
     * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
     * </pre>
     *
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception if an error occurs
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 允许跨域请求
        http.cors().disable();
        http.csrf().disable();

        // AM 客户经理 SM 销售主管 SA 高管
        http.authorizeRequests()
                .antMatchers("/", "/index").hasAnyRole("ROOT", "ADMIN", "SM", "AM", "SA")

                .antMatchers("/opportunity/**","/plan/**").hasAnyRole("AM","SA","ROOT")
                // 高管
//                .antMatchers("/service/queryState").hasAnyRole("SM", "ROOT", "ADMIN")
                // 客户经理
                .antMatchers("/service/create.html", "/service/queryForHandle",
                        "/service/queryForFeedBack", "/service/ok", "queryCustomerByUId", "/queryLossByUId",
                       "/basic/findAllStock", "/basic/findAllProduct").hasAnyRole("AM", "ROOT", "ADMIN")
                // 管理员
                .antMatchers("/permission/list").hasAnyRole("ADMIN", "ROOT")

                //  销售主管
                .antMatchers("/service/queryState","/classity.html","classity1.html","classity2.html").hasAnyRole("SA", "ROOT", "ADMIN")
                // 系统管理员
                .antMatchers("/basic/findAllDictionary", "/permission/**").hasAnyRole("ROOT", "ADMIN")
                .antMatchers("/login", "/login.html", "/logout").permitAll();

        // 登录配置
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureForwardUrl("/login");

        // 登出配置
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");

        // 自动登录配置
        http.rememberMe();

        // 403处理
        http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
    }


    /**
     * 数据加密设置
     * 采用 BCrypt 加密
     *
     * @return 加密后密码
     */
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 不拦截资源
     *
     * @param web {@link WebSecurity}
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/css/**", "/font-awesome/**", "/fonts/**", "/img/**", "/js/**", "/plugins/**", "/tools/**");
    }


    /**
     * 账户密码配置
     *
     * @param auth 权限
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
}