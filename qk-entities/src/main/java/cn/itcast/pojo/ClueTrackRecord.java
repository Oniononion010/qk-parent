package cn.itcast.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClueTrackRecord {
    private Integer id;
    private Integer clueId;
    @TableField(fill = FieldFill.INSERT)
    private Integer userId;
    private Integer subject;
    private Integer level;
    private String record;
    private LocalDateTime nextTime;
    private Integer type;
    private Integer falseReason;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(exist = false)
    private String assignName;
}
