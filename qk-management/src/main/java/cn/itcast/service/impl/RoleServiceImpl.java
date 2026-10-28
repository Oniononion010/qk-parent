package cn.itcast.service.impl;

import com.itheima.common.PageBean;
import cn.itcast.dto.RoleDTO;
import cn.itcast.mapper.RoleMapper;
import cn.itcast.pojo.Role;
import cn.itcast.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService  {



    @Override
    public PageBean findByPageAndCondition(RoleDTO roleDTO) { //"张"
        // 1.单表的我们要习惯使用mp完成
        Page<Role> page = new Page(roleDTO.getPage(), roleDTO.getPageSize());
        //2.创建mp的条件构建器
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        // "" , null ,"    "
        queryWrapper.like(StringUtils.isNotBlank(roleDTO.getName()), Role::getName, roleDTO.getName())
                .eq(StringUtils.isNotBlank(roleDTO.getLabel()), Role::getLabel, roleDTO.getLabel());
       // getBaseMapper().selectPage(page, queryWrapper);
        page(page,queryWrapper);
        //3.将查询的结果封装成接口文档要的格式
        PageBean pb = new PageBean(page.getTotal(), page.getRecords());

        return pb;
    }



}
