package cn.itcast.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.itheima.common.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Autowired
    private UserHolder<Map<String ,Object>> map ;
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入填充...");
        // 这种方式, 只有当设置的属性为null或者不合法的才会帮我们自动填充
        // this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        // this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        // 这种方式, 不管前端对该属性设置值, 这个自动填充一定会覆盖它的值, 比较常用
       // if (metaObject.hasGetter("createTime") && metaObject.hasSetter("createTime")) {
       //     metaObject.setValue("createTime", LocalDateTime.now());
       // }
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
       // if (metaObject.hasGetter("updateTime") && metaObject.hasSetter("updateTime")) {
       //     metaObject.setValue("updateTime", LocalDateTime.now());
       // }
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);

        int userId = Integer.parseInt(map.get().get("id").toString());
        this.setFieldValByName("userId" , userId, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新填充...");
        //this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        //if (metaObject.hasGetter("updateTime") && metaObject.hasSetter("updateTime")) {
        //    metaObject.setValue("updateTime", LocalDateTime.now());
        //}
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}