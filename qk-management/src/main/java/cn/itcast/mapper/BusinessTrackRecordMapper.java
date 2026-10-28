package cn.itcast.mapper;

import cn.itcast.pojo.BusinessTrackRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商机跟进记录管理Mapper
 */
 @Mapper
public interface BusinessTrackRecordMapper extends BaseMapper<BusinessTrackRecord> {
}