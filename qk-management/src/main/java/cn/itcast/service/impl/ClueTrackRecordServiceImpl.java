package cn.itcast.service.impl;

import cn.itcast.mapper.ClueTrackRecordMapper;
import cn.itcast.pojo.ClueTrackRecord;
import cn.itcast.service.ClueTrackRecordService;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClueTrackRecordServiceImpl extends ServiceImpl<ClueTrackRecordMapper, ClueTrackRecord> implements ClueTrackRecordService {
}
