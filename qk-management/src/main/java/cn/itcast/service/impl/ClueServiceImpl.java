package cn.itcast.service.impl;

import cn.itcast.dto.ClueDTO;
import cn.itcast.dto.ClueFalseDTO;
import cn.itcast.mapper.ClueMapper;
import cn.itcast.pojo.Business;
import cn.itcast.pojo.Clue;
import cn.itcast.pojo.ClueTrackRecord;
import cn.itcast.service.BusinessService;
import cn.itcast.service.ClueService;
import cn.itcast.service.ClueTrackRecordService;
import cn.itcast.vo.OverviewVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.itheima.common.PageBean;
import com.itheima.common.UserHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClueServiceImpl extends ServiceImpl<ClueMapper, Clue> implements ClueService {


    @Autowired
    private UserHolder<Map<String,Object>> userHolder;

    @Override
    public PageBean findByPageAndCondition(ClueDTO clueDTO) {
        // 借助mp的分页
        IPage<Clue> page = new Page<>(clueDTO.getPage(), clueDTO.getPageSize());
        // 调用自己sql完成条件查询, 结果会封装到page中
        getBaseMapper().findByPageAndCondition(page, clueDTO);
        //我们从page中获取数据封装到PageBean中
        PageBean pb = new PageBean(page.getTotal(), page.getRecords());
        return pb;
    }

    @Override
    public void assign(Integer clueId, Integer userId) {
        // 查询clueId 线索
        Clue clue = getById(clueId);
        // 将线索的userId修改为userId
        clue.setUserId(userId);
        //将线索的status修改为2
        clue.setStatus(2);
        // 更新线索
        saveOrUpdate(clue);

    }

    @Override
    public Clue findById(int id) {

        Clue clue = getBaseMapper().findById(id);

        return clue;
    }

    @Autowired
    private ClueTrackRecordService clueTrackRecordService;

    @Override
    public void follow(Clue clue) throws Exception {
        //更新线索

        // 将我们clue中status修改成3
        clue.setStatus(3);
        saveOrUpdate(clue);

        // int i = 1/ 0;
       /* if (true) {
            throw new Exception("aaaa");
        }*/
        //添加跟进记录
        //从令牌中获取当前用户的userId才行
       // Map<String, Object> claims = userHolder.get();
       // int userId = Integer.parseInt(claims.get("id").toString());
        ClueTrackRecord ctr = ClueTrackRecord.builder()
                .clueId(clue.getId())
               // .userId(userId) // 待定
                .subject(clue.getSubject())
                .level(clue.getLevel())
                .record(clue.getRecord())
                .nextTime(clue.getNextTime())
                .type(1)
                .build();
        clueTrackRecordService.saveOrUpdate(ctr);


    }

    @Override
    public void falseClue(Integer id, ClueFalseDTO clueFalseDTO) {
        //1.更新当前线索的状态为为线索状态4
        Clue clue = getById(id);
        clue.setStatus(4);
        saveOrUpdate(clue);
        //2.条件一条跟进记录
        Map<String, Object> claims = userHolder.get();
        int userId = Integer.parseInt(claims.get("id").toString());
        ClueTrackRecord ctr = ClueTrackRecord.builder()
                .clueId(clue.getId())
                .userId(userId) // 待定
                .record(clueFalseDTO.getRemark())
                .falseReason(clueFalseDTO.getReason())
                .type(0)
                .build();
        clueTrackRecordService.saveOrUpdate(ctr);



    }

    @Autowired
    private BusinessService businessService;
    @Override
    public void toBusiness(Integer id) {
        //修改线索的状态为5
        Clue clue = getById(id);
        clue.setStatus(5);
        saveOrUpdate(clue);
        // 添加一个商机

       /* Business.builder()
                .name(clue.getName())
                .phone(clue.getPhone())
                .gender(clue.getGender())
                .age(clue.getAge())
                .wechat(clue.getWechat())
                .qq(clue.getQq())
                .channel(clue.getChannel())
                .subject(clue.getSubject())
                .clueId( id)
                .courseId(null)
                .degree(null)
                .jobStatus(null)
                .status(1)
                .userId(null)
                .nextTime(null);*/
        Business business = new Business();
        // 从一个对象中拷贝属性到另外一个对象中, 仅限拷贝相同名字相同类型的属性
        BeanUtils.copyProperties(clue, business);
        business.setStatus(1);
        business.setUserId(null);
        business.setClueId(id);
        business.setId(null);
        business.setNextTime(null);
        businessService.saveOrUpdate(business);




    }

    @Override
    public PageBean pool(ClueDTO clueDTO) {
        IPage<Clue> page = new Page<>(clueDTO.getPage(), clueDTO.getPageSize());
        IPage<Clue> p =  getBaseMapper().pool(page, clueDTO);
        PageBean pb = new PageBean(p.getTotal(), p.getRecords());
        return pb;
    }

    @Override
    public OverviewVo overview() {


        return getBaseMapper().overview();
    }
}
