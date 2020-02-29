package com.lbhz.service;

import com.lbhz.common.response.BaseResult;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-04 20:33
 */
public interface UserService {
    /**
     * 用户登陆，获得token
     * @param userName
     * @param password
     * @return
     */
    BaseResult userLogin(String userName, String password);

    /**
     * 用户获得已登陆的信息
     * @param token
     * @return
     */
    BaseResult getUserInfo(String token);
}
