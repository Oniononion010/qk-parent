package cn.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptDTO {

    private String name;
    private Integer status;
    private Integer page = 1;
    private Integer pageSize = 10;
}
