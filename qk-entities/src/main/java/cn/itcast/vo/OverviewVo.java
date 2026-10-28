package cn.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OverviewVo {
    private Integer clueTotal; // 线索总数
    private Integer clueWaitAllot;// 待分配线索
    private Integer clueWaitFollow;
    private Integer clueFollowing;
    private Integer clueFalse;
    private Integer clueConvertBusiness;
    private Integer businessTotal;
    private Integer businessWaitAllot;
    private Integer businessWaitFollow;
    private Integer businessFollowing;
    private Integer businessFalse;
    private Integer businessConvertCustomer;
}
