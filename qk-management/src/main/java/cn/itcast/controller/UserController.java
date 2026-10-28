package cn.itcast.controller;

import com.itheima.common.PageBean;
import com.itheima.common.Result;
import cn.itcast.dto.UserDTO;
import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Result findByPageAndCondition(UserDTO userDTO) {

        PageBean pb = userService.findByPageAndCondition(userDTO);
        //将pb封装统一接口Result返回即可
        return pb != null ? Result.ok(pb) : Result.error("没有查询到用户信息");
    }

    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids) {

        userService.removeBatchByIds(ids);
        return Result.ok();
    }

    @PostMapping
    public Result add(@RequestBody User user) {
        userService.add(user);
        return Result.ok();
    }


    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        return userService.getById(id) != null ? Result.ok(userService.getById(id)) : Result.error("没有查询到用户信息");
    }

    @PutMapping
    public Result update(@RequestBody User  user) {
        userService.saveOrUpdate( user);
        return Result.ok();
    }

    @GetMapping("/list")
    public Result findAll(){
        return userService.list() != null ? Result.ok(userService.list()) : Result.error("没有查询到用户信息");

    }
    @GetMapping("/role/{roleLabel}")
    public Result findByRoleLabel( @PathVariable String roleLabel){
      List<User>  list = userService.findByRoleLabel(roleLabel);
      return list != null ? Result.ok(list) : Result.error("没有查询到用户信息");
    }

    @GetMapping("/dept/{deptId}")
    public Result findByDeptId(@PathVariable Integer deptId){
        List<User> list = userService.list(Wrappers.lambdaQuery(User.class).eq(User::getDeptId, deptId));
        return list != null ? Result.ok(list) : Result.error("没有查询到用户信息");
    }

}
