package cn.itcast.service;

import com.itheima.common.PageBean;
import cn.itcast.dto.DeptDTO;
import cn.itcast.pojo.Dept;

import java.util.List;

//alt + ctrl + B 可以快速找到当前接口或者当前类的子类
public interface DeptService {
    /**
     * 分页条件查询
     * @param deptDTO 查询参数
     * @return 分页结果集
     */
    PageBean findByPageAndCondition(DeptDTO deptDTO);

    /**
     * 根据id删除部门
     * @param id 部门id
     * @return 删除结果
     */
    int deleteById(Integer id);

    /**
     * 添加部门
     * @param dept 部门信息
     * @return 添加结果
     */
    int add(Dept dept);

    /**
     *  根据id查询部门信息
     * @param id 部门id
     * @return 部门信息
     */
    Dept findById(Integer id);

    /**
     * 修改部门信息
     * @param dept 部门信息
     * @return 修改结果
     */
    int update(Dept dept);

    /**
     * 查询所有部门信息
     * @return 部门信息
     */
    List<Dept> findAll();
}
