package cn.itcast.exception;

import com.itheima.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 标注这个类是全局异常类
public class GlobalException {

    // 编写处理异常方法
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();

        return Result.error(e.getMessage());
    }



}
