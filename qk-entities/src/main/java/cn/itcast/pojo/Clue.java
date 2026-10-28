package cn.itcast.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clue {

    private Integer id; //     '线索ID, 主键',
    private String phone; //     '手机号',
    private Integer channel; //'渠道来源，1:线上活动, 2:推广介绍',
    private Integer activityId; // '活动信息，关联活动的ID',
    private String name; //     '客户姓名',
    private Integer gender; // '性别，1:男, 2:女',
    private Integer age; // '年龄',
    private String wechat; // '微信号',
    private String qq; // 'QQ号',
    private Integer userId; //     '归属人ID，关联用户ID',
    private Integer status ; // '线索状态，1:待分配, 2:待跟进, 3:跟进中, 4:伪线索, 5:转为商机',
    private Integer subject; // '意向学科，1:AI智能应用开发(Java), 2:AI大模型开发(Python)，3:AI鸿蒙开发，4:AI大数据，5:AI嵌入式，6:AI测试，7:AI运维',
    private Integer level; // '意向等级, 1:近期学习、2:打算学习(考虑中)、3:进行了解、4:打酱油',
   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime nextTime; //  '下次跟进时间',
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; //     comment '创建时间',
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime; //     comment '修改时间'
    @TableField(exist = false)
    private String assignName;
    @TableField(exist = false)
    private List<ClueTrackRecord> trackRecords;
    @TableField(exist = false)
    private String record;
    @TableField(exist = false)
    private String activityName;
}
