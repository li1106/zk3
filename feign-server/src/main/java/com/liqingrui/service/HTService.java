package com.liqingrui.service;

import com.liqingrui.bean.HeTong;
import com.liqingrui.bean.HuiKuan;
import com.liqingrui.bean.SelectVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@FeignClient(name = "crud-server")
@RestController
public interface HTService {
    Page<HuiKuan> getList(SelectVo selectVo, Integer pageNum, Integer pageSize);

    HuiKuan getHKbyId(String hkId);

    List<HeTong> getHTList();

    void del(String hkId);

    void save(HuiKuan huiKuan);
}
