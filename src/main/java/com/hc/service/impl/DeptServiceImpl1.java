package com.hc.service.impl;

import com.hc.domain.Dept;
import com.hc.mapper.DeptMapper;
import com.hc.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("deptService1")
public class DeptServiceImpl1 implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByDeptno(Integer deptno) {
        deptMapper.deleteByPrimaryKey(deptno);
        throw new RuntimeException("数据删除出错"); //模拟出错
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED)
    public int save(Dept record) {
        int res1 = deptMapper.insert(record);//插入
        int res2 = deleteByDeptno(83);//更新，没有使用代理，事务传播不会生效
        //System.out.println(3 / 0); //模拟出错
        return res1 + res2;
    }

}
