package cn.itcast.controller;

import com.itheima.common.PageBean;
import com.itheima.common.Result;
import cn.itcast.dto.RoleDTO;
import cn.itcast.pojo.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    vo: view object ===> 主要是为匹配前端响应结果单独设定的特殊类我们称为VO,不是和数据库表进行完美对接

    dto: data transfer object ===> 主要为了封装请求参数的bean, 这个bean不是和数据库对接我们一般定义dto

    pojo/entities ==> 专门用于和数据库的表对接的bean, 我们一般定义成pojo/entities
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    //注入业务层
    @Autowired
    private RoleService roleService;

    /**
     * 分页条件查询
     * @param roleDTO
     * @return
     */
    @GetMapping
    public Result findByPageAndCondition(RoleDTO roleDTO) {
        //1.接受前端参数
        //2.参数复杂要学会封装参数
        //3.调用service查询
        PageBean pb = roleService.findByPageAndCondition(roleDTO);
        //4.统一结果集然后再返回前端
        return pb != null ? Result.ok(pb) : Result.error("没有查询到部门信息");
    }


    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        boolean flag = roleService.removeById(id);
        return flag ? Result.ok("删除成功") : Result.error("删除失败");
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Role role) {
       // role.setCreateTime(LocalDateTime.now());
       // role.setUpdateTime(LocalDateTime.now());
            //调用service处理数据
        return roleService.saveOrUpdate(role) ? Result.ok("添加成功") : Result.error("添加失败");
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        //调用service层完成工作即可
       Role role = roleService.getById(id);
       return  role == null ? Result.error("没有查询到部门信息") : Result.ok(role);

    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Role role){
       // role.setUpdateTime(LocalDateTime.now());
        //调用service层完成工作即可
        boolean flag = roleService.saveOrUpdate(role);
        return flag ? Result.ok("修改成功") : Result.error("修改失败");

    }

    /**
     * 查询所有
     * @return
     */

    @GetMapping("/list")
    public Result findAll(){
       List<Role> list =  roleService.list();
       return Result.ok(list);
    }
}
