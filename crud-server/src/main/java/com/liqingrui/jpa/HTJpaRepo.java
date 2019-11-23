package com.liqingrui.jpa;

import com.liqingrui.bean.HuiKuan;
import com.liqingrui.bean.SelectVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface HTJpaRepo extends JpaRepository<HuiKuan,String>, JpaSpecificationExecutor<SelectVo> {
    @Query(nativeQuery = true,value = "delete from huikuan where hk_id in (?1)")
    @Modifying
    @Transactional
    void delBatch(String[] split);
}
