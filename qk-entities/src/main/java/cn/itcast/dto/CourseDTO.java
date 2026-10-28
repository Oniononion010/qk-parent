package cn.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private String name;
    private Integer subject;
    private Integer target;
    private Integer page = 1;
    private Integer pageSize = 10;
}
