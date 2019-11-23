package com.liqingrui.service;

import com.liqingrui.bean.HeTong;
import com.liqingrui.bean.HuiKuan;
import com.liqingrui.bean.SelectVo;
import com.liqingrui.jpa.HTJpaRepo;
import com.liqingrui.jpa.JpaHeTongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HTServiceImpl implements HTService {
    @Autowired
    private HTJpaRepo htJpaRepo;
    @Autowired
    private JpaHeTongRepo jpaHeTongRepo;

    @Override
    public Page<HuiKuan> getList(SelectVo selectVo, Integer pageNum, Integer pageSize) {
        PageRequest request = PageRequest.of(pageNum, pageSize);
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(!StringUtils.isEmpty(selectVo.getHtId())){
                    Predicate htId = cb.like(root.get("heTong"), "%"+selectVo.getHtId()+"%");
                    list.add(htId);
                }
                if(!StringUtils.isEmpty(selectVo.getContent())){
                    Predicate htId = cb.like(root.get("hname"),"%"+selectVo.getContent()+"%");
                    list.add(htId);
                }
                if(!StringUtils.isEmpty(selectVo.getStartHk()) && !StringUtils.isEmpty(selectVo.getEndHk())){
                    Predicate htId = cb.between(root.get("hkDate"),selectVo.getStartHk(),selectVo.getEndHk());
                    list.add(htId);
                }
                if(!StringUtils.isEmpty(selectVo.getStartMoney()) && !StringUtils.isEmpty(selectVo.getEndMoney())){
                    Predicate htId = cb.between(root.get("hkMoney"),selectVo.getStartMoney(),selectVo.getEndMoney());
                    list.add(htId);
                }
                Predicate[] predicates = new Predicate[list.size()];
                predicates = list.toArray(predicates);
                Predicate predicate = cb.and(predicates);
                return predicate;
            }
        };
        Page<HuiKuan> all = htJpaRepo.findAll(specification,request);
        return all;
    }

    @Override
    public HuiKuan getHKbyId(String hkId) {
        Optional<HuiKuan> huiKuan = htJpaRepo.findById(hkId);
        HuiKuan kuan = huiKuan.get();
        return kuan;
    }

    @Override
    public void save(HuiKuan huiKuan) {
        htJpaRepo.saveAndFlush(huiKuan);
    }

    @Override
    public List<HeTong> getHTList() {
        List<HeTong> heTongList = jpaHeTongRepo.findAll();
        return heTongList;
    }

    @Override
    public void del(String hkId) {
        String[] split = hkId.split(",");
        htJpaRepo.delBatch(split);
    }
}
