package cn.itcast.interceptor;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.itheima.common.UserHolder;
import com.itheima.utils.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;


/*
    拦截器首先会执行preHandle的代码, 如果结果为false,则后面postHandle,afterCompletion乃至controller层以及之后的代码都不执行
    如果为true, 则先走controller以及之后的代码, 然后回来走拦截器的postHandle方法, 然后再走afterCompletion方法
    postHandle 和 afterCompletion的区别???

        postHandle: 不过有多个拦截器, 只有有一个return false, 则所有拦截器的postHandle中的代码都不会执行
        而afterCompletion不一样, 只有当前的返回false的那个拦截器的afterCompletion不会走, 剩余走过的拦截器的afterCompletion都会走


 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserHolder userHolder;

    @Autowired
    private JWTUtils jwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1.获取前端带的令牌
        String token = request.getHeader("token");
        //2.判断是否存在令牌
        if(StringUtils.isBlank(token)){
            response.setStatus(401);
            return false;
        }
        //3.解析令牌
        try {
            Map<String, Object> claims = jwtUtils.parseToken(token);
            //将我的数据存入到中转站中
            userHolder.set(claims);
        } catch (Exception e) {
            //令牌要么过期要么被篡改
            response.setStatus(401);
            return false;

        }
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //将本次请求的载荷从中转站移除即可
        userHolder.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
