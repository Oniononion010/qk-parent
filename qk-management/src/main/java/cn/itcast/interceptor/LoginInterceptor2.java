package cn.itcast.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/*
    拦截器首先会执行preHandle的代码, 如果结果为false,则后面postHandle,afterCompletion乃至controller层以及之后的代码都不执行
    如果为true, 则先走controller以及之后的代码, 然后回来走拦截器的postHandle方法, 然后再走afterCompletion方法
    postHandle 和 afterCompletion的区别???

    postHandle: 不过有多个拦截器, 只有有一个return false, 则所有的postHandle中的代码都不会执行
    而afterCompletion不一样, 只有当前的返回false的那个拦截器的afterCompletion不会走, 剩余走过的拦截器的afterCompletion都会走


 */
@Component
public class LoginInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // true代表放行,  false代表不放行
        System.out.println("拦截器preHandle方法工作了3");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器的postHandle走了3");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

        System.out.println("拦截器的afterCompletion走了3");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
