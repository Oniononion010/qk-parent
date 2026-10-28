package cn.itcast.mapper;

import cn.itcast.pojo.Business;
import cn.itcast.vo.OverviewVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商机管理Mapper
 */
 @Mapper
public interface BusinessMapper extends BaseMapper<Business> {
    OverviewVo overview();
}