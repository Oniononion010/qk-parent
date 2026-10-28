package cn.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String name; // 用户名称
    private Integer status;// 状态
    private String phone;//  手机
    private Integer deptId;// 部门id
    private Integer page = 1;// 页码
    private Integer pageSize = 10;// 每页记录数
    private Integer start;// 开始的索引
}
