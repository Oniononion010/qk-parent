package cn.itcast.service;

import cn.itcast.pojo.Business;
import cn.itcast.vo.OverviewVo;
import com.baomidou.mybatisplus.spring.service.IService;

public interface BusinessService extends IService<Business> {
    /**
     * 统计商机的数据
     * @return
     */
    OverviewVo overview();
}
