package cn.itcast.service;

import cn.itcast.dto.ClueDTO;
import cn.itcast.dto.ClueFalseDTO;
import cn.itcast.pojo.Clue;
import cn.itcast.vo.OverviewVo;
import com.baomidou.mybatisplus.spring.service.IService;
import com.itheima.common.PageBean;
import org.springframework.transaction.annotation.Transactional;

// alt + ctrl + B
public interface ClueService extends IService<Clue> {
    /**
     * 分页条件查询
     * @param clueDTO
     * @return
     */
    PageBean findByPageAndCondition(ClueDTO clueDTO);

    /**
     * 分配线索
     * @param clueId 线索id
     * @param userId 用户id
     */
    void assign(Integer clueId, Integer userId);

    /**
     * 根据id查询线索以及其对应的跟进记录
     * @param id
     * @return
     */
    Clue findById(int id);

    /**
     * 跟进线索
     * @param clue
     */
    @Transactional(rollbackFor = Exception.class)
    void follow(Clue clue) throws Exception;

    /**
     * 标记伪线索
     * @param id
     * @param clueFalseDTO
     */
    @Transactional(rollbackFor = Exception.class)
    void falseClue(Integer id, ClueFalseDTO clueFalseDTO);

    /**
     * 转为商机
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    void toBusiness(Integer id);

    /**
     * 线索池
     * @param clueDTO
     * @return
     */
    PageBean pool(ClueDTO clueDTO);

    /**
     * 统计线索的数据
     * @return
     */
    OverviewVo overview();
}

