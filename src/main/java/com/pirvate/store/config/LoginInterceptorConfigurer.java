package com.pirvate.store.config;

import com.pirvate.store.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/22  3:26
 * Description(说明)):
 * 处理器拦截器的注册
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> whiteList = new ArrayList<>();
        whiteList.add("/bootstrap3/**");
        whiteList.add("/css/**");
        whiteList.add("/images/**");
        whiteList.add("/js/**");
        whiteList.add("/upload/**");
        whiteList.add("/web/index.html");
        whiteList.add("/web/login.html");
        whiteList.add("/web/register.html");
        whiteList.add("/users/reg");
        whiteList.add("/users/login");
        whiteList.add("/index.html");

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //拦截全部 黑名单
                .excludePathPatterns(whiteList); //放行部分 白名单
    }

    /**
     * 资源处理  springboot 在上传文件后需要重启服务器才能访问，配置本地路径替换解决这个问题
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:E:\\ideaProject\\store\\src\\main\\resources\\static\\upload\\");
    }
}
