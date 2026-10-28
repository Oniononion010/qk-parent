package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
/*第一种导入第三方bean到ioc容器中, 不好*/
/*@ComponentScans(
        @ComponentScan({"com.itheima" ,"cn.itcast",})
)*/
/*第二种方式 @Import ===> 也不好*/
//@Import({AliProperties.class, OSSUtils.class})
/*第三种方式:
第三方框架, 将核心的对象都整合到配置类, 我们只需要找一个配置类,
所以核心的bean都会引入到ioc容器中
不好: 最起码一个框架必须记住一个配置类
*/
//@Import({AutoConfiguration.class})
@EnableAspectJAutoProxy // 开启AOP
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
