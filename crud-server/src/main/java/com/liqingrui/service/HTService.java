package com.liqingrui.service;

import com.liqingrui.bean.HeTong;
import com.liqingrui.bean.HuiKuan;
import com.liqingrui.bean.SelectVo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HTService {
    Page<HuiKuan> getList(SelectVo selectVo, Integer pageNum, Integer pageSize);

    HuiKuan getHKbyId(String hkId);

    void save(HuiKuan huiKuan);

    List<HeTong> getHTList();

    void del(String hkId);
}
