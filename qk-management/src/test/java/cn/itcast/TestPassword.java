package cn.itcast;

import com.itheima.utils.AliProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestPassword {


    @Autowired
    private AliProperties aliProperties;

    @Test
    public void testSafe(){
       // String password = "123456";
       // String s = DigestUtils.md5DigestAsHex(password.getBytes());
       // System.out.println(s);

        System.out.println(aliProperties);

    }
}
