package com.project.QuickProject.common.utils;

import com.project.QuickProject.common.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
@author Jimmey-Jiang
 * @desc UserUtils 获取当前的登录用户信息
 */
public class UserUtils {

    public static LoginUser getLoginUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return loginUser;
    }

    public static String getUserName() {
        return getLoginUser().getUsername();
    }

}
