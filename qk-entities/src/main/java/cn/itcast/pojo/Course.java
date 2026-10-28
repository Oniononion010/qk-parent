package cn.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Integer id; //课程编号
    private Integer subject; //课程类别课程学科，1:AI智能应用开发(Java), 2:AI大模型开发(Python)，3:AI鸿蒙开发，4:AI大数据，5:AI嵌入式，6:AI测试，7:AI运维
    private String name; //课程名称
    private Integer price; //课程价格
    private Integer target; //课程目标适用人群, 1:小白学员, 2:初级程序员, 3:中级程序员
    private String description; //课程描述
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //更新时间
}
