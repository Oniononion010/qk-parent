package cn.itcast.controller;

import com.itheima.common.Result;
import com.itheima.utils.OSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    /*
        spring-web的处理方式:
        1. 将上传项给我们封装到MultipartFile这个类型中了
        注意: 参数名必须和上传项的name的值的保持一致即可!!!
     */
    /*@PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        //获取文件的原始名字
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        //获取name属性对应的值
        String name = file.getName();
        System.out.println(name);
        String uuid = UUID.randomUUID().toString();
        file.transferTo(new File("g:/upload/"+uuid+"_"+ originalFilename));
        return Result.ok("上传成功");
    }*/

    //注入ossutils对象
    @Autowired
    private OSSUtils ossUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {



        String url = ossUtils.upload(file);

        return Result.ok(url);
    }

}
