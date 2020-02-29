package com.lbhz.service.impl;

import com.lbhz.common.response.BaseResult;
import com.lbhz.common.response.BaseResultFactory;
import com.lbhz.common.response.Code;
import com.lbhz.core.bean.auto.UserBean;
import com.lbhz.core.dao.auto.UserBeanMapper;
import com.lbhz.model.JwtTokenInfo;
import com.lbhz.service.TokenService;
import com.lbhz.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;


/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-05 18:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserBeanMapper userDao;
    @Autowired
    private TokenService tokenService;


    @Override
    public BaseResult userLogin(String userName, String password) {
        UserBean userEntity = userDao.selectByPrimaryKey(userName);
        if (loginSuccess(userEntity, password)) {
            JwtTokenInfo tokenInfo = new JwtTokenInfo();
            tokenInfo.setUserName(userEntity.getUserName());
            return BaseResultFactory.produceResult(Code.SUCCESS,tokenService.createToken(tokenInfo));
        }
        return BaseResultFactory.produceEmptyResult(Code.INCORRECT_PASSWORD);

    }

    /**
     * 用于判断是否登陆成功，现在还是简单的判断数据库里的密码和用户输入的是否一致
     * @param userEntity
     * @param password
     * @return
     */
    private boolean loginSuccess(UserBean userEntity, String password) {
        if (ObjectUtils.isEmpty(userEntity)) {
            return false;
        }
        return userEntity.getPassword().equals(password);
    }

    @Override
    public BaseResult getUserInfo(String token) {
        JwtTokenInfo tokenInfo = tokenService.verifyToken(token);
        UserBean userBean = userDao.selectByPrimaryKey(tokenInfo.getUserName());
        return BaseResultFactory.produceResult(Code.SUCCESS, userBean);
    }

}
