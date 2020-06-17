package com.hc.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.hc.mapper.DeptMapper;
import com.hc.domain.Dept;
import com.hc.service.DeptService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("deptService2")
public class DeptServiceImpl2 implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByDeptno(Integer deptno) {
        deptMapper.deleteByPrimaryKey(deptno);
        throw new RuntimeException("数据删除出错"); //模拟出错
    }

    @Resource(name = "deptService2")
    private DeptService deptService;

    @Override
    //@Transactional(propagation = Propagation.REQUIRED)
    public int save(Dept record) {
        int res1 = deptMapper.insert(record);//插入
        int res2 = deptService.deleteByDeptno(84);//更新
        //System.out.println(3 / 0); //模拟出错
        return res1 + res2;
    }

}
