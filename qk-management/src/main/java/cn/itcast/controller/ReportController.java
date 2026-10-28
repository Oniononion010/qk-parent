package cn.itcast.controller;

import cn.itcast.service.ReportService;
import cn.itcast.vo.OverviewVo;
import com.itheima.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ReportController {

    @Autowired
    private ReportService reportService;
    @GetMapping("/report/overview")
    public Result overview(){

      OverviewVo overviewVo =  reportService.overview();
      return Result.ok(overviewVo);
    }
}
