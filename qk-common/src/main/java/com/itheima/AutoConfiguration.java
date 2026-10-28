package com.itheima;

import com.itheima.common.UserHolder;
import com.itheima.utils.AliProperties;
import com.itheima.utils.JWTUtils;
import com.itheima.utils.OSSUtils;
import org.springframework.context.annotation.Bean;

public class AutoConfiguration {


    @Bean // 将我们的返回值的bean放到ioc容器中
    public AliProperties aliProperties(){
        return new AliProperties();
    }

    @Bean // 将我们的返回值的bean放到ioc容器中
    public OSSUtils ossUtils() {
        return new OSSUtils();
    }

    @Bean // 将我们的返回值的bean放到ioc容器中
    public JWTUtils jwtUtils() {
        return new JWTUtils();
    }


    @Bean // 将我们的返回值的bean放到ioc容器中
    public UserHolder userHolder() {
        return new UserHolder();
    }
}
