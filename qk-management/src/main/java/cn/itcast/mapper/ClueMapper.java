package cn.itcast.mapper;

import cn.itcast.dto.ClueDTO;
import cn.itcast.pojo.Clue;
import cn.itcast.vo.OverviewVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClueMapper extends BaseMapper<Clue> {
    IPage findByPageAndCondition(IPage<Clue> page, ClueDTO clueDTO);

    Clue findById(int id);

    IPage<Clue> pool(IPage<Clue> page, ClueDTO clueDTO);

    OverviewVo overview();

}
