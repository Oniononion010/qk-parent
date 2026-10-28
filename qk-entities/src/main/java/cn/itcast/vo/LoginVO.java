package cn.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginVO {

    private Integer id;
    private String username;
    private String name;
    private String image;
    private String token;
    private String roleLabel;
}
