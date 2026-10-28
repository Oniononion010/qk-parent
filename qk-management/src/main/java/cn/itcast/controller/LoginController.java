package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import cn.itcast.vo.LoginVO;
import com.itheima.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {

        //log.info("登录的用户是:{}", user);
        LoginVO loginVO = userService.login(user);
        return Result.ok(loginVO);

    }
}
