package com.liqingrui.controller;

import com.liqingrui.bean.HeTong;
import com.liqingrui.bean.HuiKuan;
import com.liqingrui.bean.SelectVo;
import com.liqingrui.service.HTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/hetong")
public class HTController {
    @Autowired
    private HTService htService;

    @GetMapping("/getList")
    public Map<String,Object> getList(SelectVo selectVo, @RequestParam(name = "pageNum",defaultValue = "0")Integer pageNum,
                                      @RequestParam(name = "pageSize",defaultValue = "2")Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        Page<HuiKuan> pages = htService.getList(selectVo,pageNum,pageSize);
        map.put("list",pages);
        System.out.println(selectVo);
        return map;
    }

    @GetMapping("/getHKbyId")
    public HuiKuan getHKbyId(String hkId){
        HuiKuan kuan = htService.getHKbyId(hkId);
        return kuan;
    }

    @PostMapping("/save")
    public void save(@RequestBody HuiKuan huiKuan){

        htService.save(huiKuan);
    }
    @GetMapping("/getHTList")
    public List<HeTong> getHTList(){
        List<HeTong> htList = htService.getHTList();
        System.err.println(htList);
        return htList;
    }
    @GetMapping("/del")
    public void del(String hkId){
        htService.del(hkId);
    }
}
