package cn.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {

    private Integer channel;
    private Integer type;
    private Integer page = 1;
    private Integer pageSize = 10;
}
