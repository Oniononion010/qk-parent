package cn.itcast.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClueDTO {
    private Integer clueId;// 线索id
    private String phone;// 手机号
    private Integer status;// 线索状态，1:待分配, 2:待跟进, 3:跟进中, 4:伪线索, 5:转为商机
    private Integer channel;// 渠道
    private String assignName;// 分配人
    private Integer page; // 当前页
    private Integer pageSize;// 每页显示的条数
}
