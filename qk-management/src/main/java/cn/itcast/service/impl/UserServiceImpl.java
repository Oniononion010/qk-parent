package cn.itcast.service.impl;

import cn.itcast.vo.LoginVO;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.itheima.common.PageBean;
import cn.itcast.dto.UserDTO;
import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.itheima.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


   // @Autowired
   // private RoleService roleService;

    @Autowired
    private JWTUtils jwtUtils;
    @Override
    public PageBean findByPageAndCondition(UserDTO userDTO) {
        //解决开始索引的计算问题
        IPage<User> page = new Page<>(userDTO.getPage(), userDTO.getPageSize());
        //调用dap层完成total 和rows的数据
        getBaseMapper().findByPageAndCondition(page, userDTO);
        //将两个数据打包到PageBean中返回即可
        PageBean pb = PageBean.builder().rows(page.getRecords()).total(page.getTotal()).build();

        return pb;
    }

    @Override
    public void add(User user) {
        //补全密码, 创建时间, 更新时间, 采用MD5技术完成对密码的加密
        String safePassword = DigestUtils.md5DigestAsHex((user.getUsername() + "123").getBytes());
        user.setPassword(safePassword);
        //调用业务层自己的方法保存用户
        saveOrUpdate(user);

    }

    @Override
    public List<User> findByRoleLabel(String roleLabel) {

        return getBaseMapper().findByRoleLabel(roleLabel);
    }

    @Override
    public LoginVO login(User user) {
        //校验用户名不能为null
        if(StringUtils.isBlank(user.getUsername())){
            throw  new RuntimeException("用户名不能为null");
        }
       User loginUser = getBaseMapper().findByUsername(user.getUsername());
        //查询用户名对应的用户是否存在
        //User loginUser = getOne(Wrappers.lambdaQuery(User.class).eq(User::getUsername, user.getUsername()));
        if(loginUser == null){
            throw new RuntimeException("用户名或密码错误");
        }
        //对比密码是否一致
        String inputPassword = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        if(!loginUser.getPassword().equals(inputPassword)){
            throw new RuntimeException("用户名或密码错误");
        }
        //查询用户是否禁用
        if (loginUser.getStatus().equals(0)){
            throw new RuntimeException("用户被禁用");
        }
        //根据用户中的角色id去查询角色对象, 获取角色描述
       // Role role = roleService.getById(loginUser.getRoleId());
        // 做token
        Map<String,Object> claims = new HashMap<>();
        claims.put("name",loginUser.getName());
        claims.put("id",loginUser.getId());

        String token = jwtUtils.makeToken(claims);
        LoginVO loginVO = LoginVO.builder()
                .id(loginUser.getId())
                .username(loginUser.getUsername())
                .name(loginUser.getName())
                .image(loginUser.getImage())
                .roleLabel(loginUser.getRoleLabel())
                .token(token)
                .build();
        return loginVO;
    }
    //原始版多表分页查询
    /* @Override
    public PageBean findByPageAndCondition(UserDTO userDTO) {
        //解决开始索引的计算问题
        userDTO.setStart((userDTO.getPage() - 1) * userDTO.getPageSize());
        //调用dap层完成total 和rows的数据
        List<User> rows = getBaseMapper().findByPageAndCondition(userDTO);
        long total = getBaseMapper().findByPageAndConditionTotal(userDTO);
        //将两个数据打包到PageBean中返回即可
        PageBean pb = PageBean.builder().rows(rows).total(total).build();

        return pb;
    }*/
   /* @Override
    public PageBean findByPageAndCondition(UserDTO userDTO) {
        //分页条件
        Page<User> page = new Page<>(userDTO.getPage(), userDTO.getPageSize());
        //动态条件
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();

        lqw.like(StringUtils.isNotBlank(userDTO.getName()), User::getName, userDTO.getName())
                .eq(userDTO.getStatus() != null, User::getStatus, userDTO.getStatus())
                .like(StringUtils.isNotBlank(userDTO.getPhone()), User::getPhone, userDTO.getPhone())
                .eq(userDTO.getDeptId() != null, User::getDeptId, userDTO.getDeptId());
        //分页条件查询
        baseMapper.selectPage(page, lqw);
        //将数据取出来给PageBean
       // PageBean pb = new PageBean(page.getTotal(), page.getRecords());
        PageBean pb = PageBean.builder()
                        .total(page.getTotal())
                        .rows(page.getRecords())
                        .build();

        List rows = pb.getRows();
        for (Object row : rows) {
            ro
        }
        return pb;
    }*/
}
