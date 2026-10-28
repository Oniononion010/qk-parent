package cn.itcast.service.impl;

import com.itheima.common.PageBean;
import cn.itcast.dto.DeptDTO;
import cn.itcast.mapper.DeptMapper;
import cn.itcast.pojo.Dept;
import cn.itcast.pojo.User;
import cn.itcast.service.DeptService;
import cn.itcast.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    //注入mapper对象
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private UserService userService;

    @Override
    public PageBean findByPageAndCondition(DeptDTO deptDTO) { //"张"
        // 1.单表的我们要习惯使用mp完成
        Page<Dept> page = new Page(deptDTO.getPage(), deptDTO.getPageSize());
        //2.创建mp的条件构建器
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<>();
        // "" , null ,"    "
        queryWrapper.like(StringUtils.isNotBlank(deptDTO.getName()), Dept::getName, deptDTO.getName())
                .eq(deptDTO.getStatus() != null, Dept::getStatus, deptDTO.getStatus());
        deptMapper.selectPage(page, queryWrapper);
        //3.将查询的结果封装成接口文档要的格式
        PageBean pb = new PageBean(page.getTotal(), page.getRecords());

        return pb;
    }

    @Override
    public int deleteById(Integer id) {
        // 判断是否有员工, 有员工给出删除失败的提醒
        if(userService.count(Wrappers.lambdaQuery(User.class).eq(User::getDeptId, id)) > 0 ) throw  new RuntimeException("该部门有员工删除失败");

        // 需要查看这个部门是否与用户
        return deptMapper.deleteById(id);
    }

    @Override
    public int add(Dept dept) {
        //1.补全参数
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //2.校验参数
        // ...
        return deptMapper.insert(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public int update(Dept dept) {
        // 不用补全参数的, 无效的参数也不会被修改
        // 将修改时间设置成当前时间
        dept.setUpdateTime(LocalDateTime.now());
        return deptMapper.updateById(dept);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.selectList(null);
    }
}
