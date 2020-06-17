package com.hc.service.impl;

import com.hc.domain.Dept;
import com.hc.mapper.DeptMapper;
import com.hc.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("deptService10")
public class DeptServiceImpl10 implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int deleteByDeptno(Integer deptno) {
        int res = deptMapper.deleteByPrimaryKey(deptno);
        System.out.println(2/0);
        return res;
    }

    @Resource(name = "deptService10")
    private DeptService deptService;

    @Override
    @Transactional
    public int save(Dept record) {
        int res1 = deptMapper.insert(record);//插入
        int res2 = deptService.deleteByDeptno(88);//更新
        System.out.println(3 / 0); //模拟出错
        return res1 + res2;
    }

}
