package com.hc.service.impl;

import com.hc.domain.Dept;
import com.hc.mapper.DeptMapper;
import com.hc.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("deptService9")
public class DeptServiceImpl9 implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int deleteByDeptno(Integer deptno) {
        return deptMapper.deleteByPrimaryKey(deptno);
    }

    @Resource(name = "deptService9")
    private DeptService deptService;

    @Override
    @Transactional
    public int save(Dept record) {
        int res1 = deptMapper.insert(record);//插入
        int res2 = deptService.deleteByDeptno(87);//更新
        System.out.println(3 / 0); //模拟出错
        return res1 + res2;
    }

}
