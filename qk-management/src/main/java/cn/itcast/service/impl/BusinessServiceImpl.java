package cn.itcast.service.impl;

import cn.itcast.mapper.BusinessMapper;
import cn.itcast.pojo.Business;
import cn.itcast.service.BusinessService;
import cn.itcast.vo.OverviewVo;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business>  implements BusinessService {
    @Override
    public OverviewVo overview() {
        return getBaseMapper().overview();
    }
}
