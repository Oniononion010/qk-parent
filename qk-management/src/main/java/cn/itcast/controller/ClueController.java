package cn.itcast.controller;

import cn.itcast.aspect.Log;
import cn.itcast.dto.ClueDTO;
import cn.itcast.dto.ClueFalseDTO;
import cn.itcast.pojo.Clue;
import cn.itcast.service.ClueService;
import com.itheima.common.PageBean;
import com.itheima.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clues")
public class ClueController {
    //注入service
    @Autowired
    private ClueService clueService;


    @GetMapping
    public Result findByPageAndCondition(ClueDTO clueDTO) {
        PageBean pb = clueService.findByPageAndCondition(clueDTO);
        return Result.ok(pb);
    }


    @PostMapping
    public Result add(@RequestBody Clue clue ){
        clueService.saveOrUpdate(clue);
        return Result.ok();
    }

    // 分配线索, 其本质就是给线索的user_id设置值
    @PutMapping("/assign/{clueId}/{userId}")
    @Log
    public Result assign(@PathVariable Integer clueId,@PathVariable Integer userId){
        clueService.assign(clueId,userId);
        return Result.ok();
    }

    // 根据id查询线索以及其对应的跟进记录列表
    @GetMapping("/{id}")
    public  Result findById(@PathVariable Integer id){
       Clue clue =clueService.findById(id);
       return Result.ok(clue);
    }


    @PutMapping
    @Log
    public Result follow(@RequestBody Clue clue) throws Exception {
        clueService.follow(clue);

        return Result.ok();

    }


    // 标记伪线索
    @PutMapping("/false/{id}")
    @Log
    public Result falseClue(@PathVariable Integer id,@RequestBody ClueFalseDTO clueFalseDTO){
        clueService.falseClue(id,clueFalseDTO);
        return Result.ok();

    }

    // 转商机
    @PutMapping("/toBusiness/{id}")
    @Log
    public Result  toBusiness(@PathVariable Integer id){
        clueService.toBusiness(id);
        return Result.ok();
    }
    //线索池
    @GetMapping( "/pool")
    public Result pool(ClueDTO clueDTO){
      PageBean pb =  clueService.pool(clueDTO);
      return Result.ok(pb);
    }




}
