package com.project.QuickProject.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.QuickProject.filter.CustomTokenFilter;
import com.project.QuickProject.log.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * spring security配置
 *
 * @author Jimmey-Jiang
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomTokenFilter customTokenFilter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()// 由于使用的是JWT，我们这里不需要csrf
                .disable()
                .sessionManagement()// 基于token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.png",
                        "/auth/login/**",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                )
                .permitAll()
                .antMatchers("/sys/sysUser/login","/sys/sysUser/loginValidateCode","/sys/sysUser/register","/sys/sysUser/login1")// 对登录注册要允许匿名访问
                .permitAll()
                /* .and()
                 .logout()
                 .invalidateHttpSession(true)
                 .permitAll()*/
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
                .antMatchers("/**")//测试时全部运行访问
                .permitAll()
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated();
        //访问 /logout 表示用户注销，并清空session
        httpSecurity.logout().logoutSuccessUrl("/logoutSuccess");
        // 禁用缓存
        httpSecurity.headers().cacheControl();
//        // 添加JWT filter
//        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//        //添加自定义未授权和未登录结果返回
//        httpSecurity.exceptionHandling()
//                .accessDeniedHandler(restfulAccessDeniedHandler)
//                .authenticationEntryPoint(restAuthenticationEntryPoint);

    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .anyRequest().permitAll().and().logout().permitAll();//配置不需要登录验证
//    }

    /*
    UsernamePasswordAuthenticationFilter是AbstractAuthenticationProcessingFilter针对使用用户名和密码进行身份验证而定制化的一个过滤器。
    其添加是在调用http.formLogin()时作用，默认的登录请求pattern为"/login"，并且为POST请求。
    当我们登录的时候，也就是匹配到loginProcessingUrl，这个过滤器就会委托认证管理器authenticationManager来验证登录。
     */
    @Bean
    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
        UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter() {
            @Override
            public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
                if (!"POST".equals(request.getMethod())) {
                    throw new AuthenticationServiceException(
                            "Authentication method not supported: " + request.getMethod());
                }
                if (request.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)) {
                    UsernamePasswordAuthenticationToken authRequest;
                    try (InputStream is = request.getInputStream()) {
                        Map authenticationBean = objectMapper.readValue(is, Map.class);
                        String username = MapUtils.getString(authenticationBean, "username", "");
                        String password = MapUtils.getString(authenticationBean, "password", "");
                        authRequest = new UsernamePasswordAuthenticationToken(username, password);
                    } catch (IOException e) {
                        authRequest = new UsernamePasswordAuthenticationToken("", "");
                    }
                    setDetails(request, authRequest);
                    Authentication authenticate = getAuthenticationManager().authenticate(authRequest);
                    return authenticate;
                } else {
                    return super.attemptAuthentication(request, response);
                }
            }
        };
        filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/auth/login", "POST"));
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(authenticationFailureHandler);
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

    //指定我们自定义的userDetailsService,还有加密方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}
