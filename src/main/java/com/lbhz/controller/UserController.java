package com.lbhz.controller;

import com.lbhz.common.response.BaseResult;
import com.lbhz.config.anno.RequestToken;
import com.lbhz.model.LoginDto;
import com.lbhz.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import static com.lbhz.common.Const.*;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-04 20:31
 */
@RestController
@RequestMapping("/api/user")
@Api //使用API注解告诉Swagger这个是一个API
public class UserController {
    @Autowired
    private UserService userService;

    @RequestToken
    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public BaseResult getUserInfo(
            @RequestHeader(ACCESS_PARAM) String token
    ) {
        System.out.println(token);
        return userService.getUserInfo(token);
    }

    @ApiOperation("用户获取token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult login(
            @ApiParam("用户名密码") @RequestBody LoginDto login
    ) {
        return userService.userLogin(login.getUserName(),login.getPassword());
    }
    

}
