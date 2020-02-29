package com.lbhz.config;

import com.lbhz.service.TokenService;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-12 20:02
 * 这是aop的配置，每一个接口鉴定token的工作都会都会在这里
 */
@Configuration
@Aspect
@Slf4j
public class AopConfig {
    @Autowired
    private TokenService tokenService;

    /**
     * 这个切面表示必须要在Controller包里并且要有@RequestToken的注解并且要有String token参数才会成为切面
     */
    @Pointcut("within(com.lbhz.controller.*) " +
            "&& @annotation(com.lbhz.config.anno.RequestToken)" +
            "&& args(token,..)")
    public void verifyAuthPointcut(String token) { }

    /**
     * ·这个方法用来处理需要登陆才能完成的请求
     * @param token
     */
    @Before("verifyAuthPointcut(token)")
    public void verifyToken(String token) throws  Exception {
        try {
            tokenService.verifyToken(token);
        } catch (JwtException e) {
            log.warn(e.getMessage());
            e.printStackTrace();
            throw new Exception("鉴权失败");
        }
    }
}
