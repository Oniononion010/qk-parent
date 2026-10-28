package cn.itcast.mapper;

import cn.itcast.dto.UserDTO;
import cn.itcast.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    IPage<User> findByPageAndCondition(IPage<User> page, UserDTO userDTO);

    List<User> findByRoleLabel(String roleLabel);

    User findByUsername(String username);
    //long findByPageAndConditionTotal(UserDTO userDTO);


}
