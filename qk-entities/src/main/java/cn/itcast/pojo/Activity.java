package cn.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private Integer id; // 主键
    private Integer channel; // 渠道 1.线上活动 2.推广介绍
    private String name; // 活动名称
    private LocalDateTime startTime; // 活动开始时间
    private LocalDateTime endTime;  // 活动结束时间
    private String description; // 活动描述
    private Integer type; // 活动类型 1. 折扣 2. 代金券
    private Double discount; // 优惠金额
    private String voucher;// 代金券金额
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间

}
