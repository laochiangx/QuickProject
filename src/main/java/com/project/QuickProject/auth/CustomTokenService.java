package com.project.QuickProject.auth;


import com.project.QuickProject.common.entity.CustomToken;
import com.project.QuickProject.common.entity.LoginUser;

/**
 * @author Jimmey-Jiang
 */

public interface CustomTokenService {

    /**
     * 保存登录token 信息
     *
     * @param loginUser 登录信息
     * @return R
     */
    CustomToken saveToken(LoginUser loginUser);

    /**
     * 刷新凭证信息，这里只是延长token的时间
     *
     * @param loginUser 登录信息
     */
    void renew(LoginUser loginUser);

    /**
     * 根据旧的token获取新的token
     * @param loginUser 登录信息
     * @return R
     */
    CustomToken refresh(LoginUser loginUser);

    /**
     * 根据token获取登录信息
     *
     * @param token jwt
     * @return R
     */
    LoginUser getLoginUser(String token);

    /**
     * 根据token删除登录细腻些
     *
     * @param token jwt
     */
    void deleteToken(String token);
}
