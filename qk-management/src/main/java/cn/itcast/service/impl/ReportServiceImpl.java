package cn.itcast.service.impl;

import cn.itcast.service.BusinessService;
import cn.itcast.service.ClueService;
import cn.itcast.service.ReportService;
import cn.itcast.vo.OverviewVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ClueService clueService;

    @Autowired
    private BusinessService businessService;
    @Override
    public OverviewVo overview() {

       //long clueTotal = clueService.count();
       //long clueWaitAllot = clueService.count(Wrappers.lambdaQuery(Clue.class).eq(Clue::getStatus, 1));
       //long clueWaitAllot = clueService.count(Wrappers.lambdaQuery(Clue.class).eq(Clue::getStatus, 1));
       //long clueWaitAllot = clueService.count(Wrappers.lambdaQuery(Clue.class).eq(Clue::getStatus, 1));
       //long clueWaitAllot = clueService.count(Wrappers.lambdaQuery(Clue.class).eq(Clue::getStatus, 1));
       //long clueWaitAllot = clueService.count(Wrappers.lambdaQuery(Clue.class).eq(Clue::getStatus, 1));
       //long clueWaitAllot = clueService.count(Wrappers.lambdaQuery(Clue.class).eq(Clue::getStatus, 1));
        //查询clueService的相关汇总
        OverviewVo clueOverView =  clueService.overview();
        //查询businessService的相关汇总
        OverviewVo businessOverView =  businessService.overview();
        //将两个合在一起返回给controller
        OverviewVo overviewVo = new OverviewVo();
        BeanUtils.copyProperties(clueOverView,overviewVo);
        BeanUtils.copyProperties(businessOverView,overviewVo,"clueTotal","clueWaitAllot", "clueWaitFollow", "clueFollowing", "clueFalse", "clueConvertBusiness");

        return overviewVo;
    }
}
