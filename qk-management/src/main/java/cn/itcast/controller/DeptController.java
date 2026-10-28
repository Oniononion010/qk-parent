package cn.itcast.controller;

import com.itheima.common.PageBean;
import com.itheima.common.Result;
import cn.itcast.dto.DeptDTO;
import cn.itcast.pojo.Dept;
import cn.itcast.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    vo: view object ===> 主要是为匹配前端响应结果单独设定的特殊类我们称为VO,不是和数据库表进行完美对接

    dto: data transfer object ===> 主要为了封装请求参数的bean, 这个bean不是和数据库对接我们一般定义dto

    pojo/entities ==> 专门用于和数据库的表对接的bean, 我们一般定义成pojo/entities
 */
@RestController
@RequestMapping("/depts")
public class DeptController {

    //注入业务层
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result findByPageAndCondition(DeptDTO deptDTO) {
        //1.接受前端参数
        //2.参数复杂要学会封装参数
        //3.调用service查询
        PageBean pb = deptService.findByPageAndCondition(deptDTO);
        //4.统一结果集然后再返回前端
        return pb != null ? Result.ok(pb) : Result.error("没有查询到部门信息");
    }


    /*
        第二种参数的格式叫做路径, 路径参数一般都少量的简单的数据
        我么需要标注第几段路径需要赋值给哪个参数变量即可,
        参数使用@PathVariable标注即可
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        int row = deptService.deleteById(id);
        return row > 0 ? Result.ok("删除成功") : Result.error("删除失败");
    }

    /*
        json格式的参数必须使用 @RequestBody
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
            //调用service处理数据
            int row = deptService.add(dept);
            return row > 0 ? Result.ok("添加成功") : Result.error("添加失败");


    }


    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){

        //调用service层完成工作即可
       Dept dept = deptService.findById(id);
       return  dept == null ? Result.error("没有查询到部门信息") : Result.ok(dept);

    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        //调用service层完成工作即可
        int row = deptService.update(dept);
        return row > 0 ? Result.ok("修改成功") : Result.error("修改失败");
    }


    @GetMapping("/list")
    public Result findAll(){
       List<Dept> list =  deptService.findAll();

       return Result.ok(list);
    }
}
