package cn.itcast.service;

import cn.itcast.vo.LoginVO;
import com.itheima.common.PageBean;
import cn.itcast.dto.UserDTO;
import cn.itcast.pojo.User;
import com.baomidou.mybatisplus.spring.service.IService;

import java.util.List;

// alt + ctrl + B
public interface UserService extends IService<User> {
    /**
     * 条件分页查询
     * @param userDTO
     * @return
     */
    PageBean findByPageAndCondition(UserDTO userDTO);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 根据角色查询用户
     * @param roleLabel
     * @return
     */
    List<User> findByRoleLabel(String roleLabel);

    /**
     * 根据用户名和密码登录
     * @param user
     * @return
     */
    LoginVO login(User user);
}
