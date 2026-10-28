package com.itheima.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer code;
    private String msg;
    private Object data;

    //内置一些创建本类对象的方式, 让使用者统一格式
    public static Result ok(){
        return new Result(1, "操作成功", "操作成功");
    }
    public static Result ok(Object data){
        return new Result(1, "操作成功", data);
    }
    public static Result ok(String msg,Object data){
        return new Result(1, msg, data);
    }
    public static Result error(String msg){
        return new Result(0, msg, null);
    }
}
