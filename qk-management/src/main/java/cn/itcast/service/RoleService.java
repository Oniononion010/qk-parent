package cn.itcast.service;

import com.itheima.common.PageBean;
import cn.itcast.dto.RoleDTO;
import cn.itcast.pojo.Role;
import com.baomidou.mybatisplus.spring.service.IService;

//alt + ctrl + B 可以快速找到当前接口或者当前类的子类
public interface RoleService extends IService<Role> {
    /**
     * 分页条件查询
     * @param roleDTO 查询参数
     * @return 分页结果集
     */
    PageBean findByPageAndCondition(RoleDTO roleDTO);

}
