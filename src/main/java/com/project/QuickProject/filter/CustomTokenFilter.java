package com.project.QuickProject.filter;

import com.project.QuickProject.auth.CustomTokenService;
import com.project.QuickProject.common.entity.CustomToken;
import com.project.QuickProject.common.entity.LoginUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token过滤器
 *
 * @author Jimmey-Jiang
 */
@Component
public class CustomTokenFilter extends OncePerRequestFilter {

    public static final String TOKEN_KEY = "Authorization";

    private static final Long DAY = 24 * 3600 * 1000L;

    @Autowired
    private CustomTokenService customTokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = getAccessToken(request);
        if (StringUtils.isNotBlank(token)) {
            LoginUser loginUser = customTokenService.getLoginUser(token);
            if (loginUser != null) {
                loginUser = checkLoginTime(loginUser);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginUser,
                        null, loginUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * 校验时间<br>
     * 如果jwt有过期时间，就不用使用此刷新redis时间了
     */
    private LoginUser checkLoginTime(LoginUser loginUser) {
        CustomToken customToken = loginUser.getCustomToken();
        long expireTime = customToken.getExpires_in().getTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime>currentTime&&expireTime - currentTime <= DAY) {
            loginUser = (LoginUser) userDetailsService.loadUserByUsername(loginUser.getUsername());
            loginUser.setCustomToken(customToken);
            customTokenService.renew(loginUser);
        }
        return loginUser;
    }

    /**
     * 根据参数或者header获取token
     */
    public static String getAccessToken(HttpServletRequest request) {
        String token = request.getParameter(TOKEN_KEY);
        if (StringUtils.isBlank(token)) {
            token = request.getHeader(TOKEN_KEY);
        }
        return token;
    }

}
