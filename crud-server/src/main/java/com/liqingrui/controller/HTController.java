package com.liqingrui.controller;

import com.liqingrui.bean.HeTong;
import com.liqingrui.bean.HuiKuan;
import com.liqingrui.bean.SelectVo;
import com.liqingrui.service.HTService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "合同 汇款的操作接口")
@RestController
@CrossOrigin
@RequestMapping("/hetong")
public class HTController {
    @Autowired
    private HTService htService;

    @ApiOperation(value = "查询首页商品分类及列表")
    @GetMapping("/getList")
    public Map<String,Object> getList(SelectVo selectVo, @RequestParam(name = "pageNum",defaultValue = "0")Integer pageNum,
                                      @RequestParam(name = "pageSize",defaultValue = "2")Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        Page<HuiKuan> pages = htService.getList(selectVo,pageNum,pageSize);
        map.put("list",pages);
        System.out.println(selectVo);
        return map;
    }

    @ApiOperation(value = "获得单条汇款信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "hkId",value = "获得汇款信息json",required = true,paramType = "body",dataType ="String")})
    @GetMapping("/getHKbyId")
    public HuiKuan getHKbyId(String hkId){
        HuiKuan kuan = htService.getHKbyId(hkId);
        return kuan;
    }
    @ApiOperation(value = "保存及修改")
    @PostMapping("/save")
    public void save(@RequestBody HuiKuan huiKuan){

        htService.save(huiKuan);
    }
    @ApiOperation(value = "获得合同列表信息")
    @GetMapping("/getHTList")
    public List<HeTong> getHTList(){
        List<HeTong> htList = htService.getHTList();
        System.err.println(htList);
        return htList;
    }
    @ApiOperation(value = "删除数据")
    @GetMapping("/del")
    public void del(String hkId){
        htService.del(hkId);
    }
}
