package com.hc.service.impl;

import com.hc.domain.Dept;
import com.hc.mapper.DeptMapper;
import com.hc.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("deptService5")
public class DeptServiceImpl5 implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int deleteByDeptno(Integer deptno) {
        deptMapper.deleteByPrimaryKey(deptno);
        throw new RuntimeException("数据删除出错"); //模拟出错
    }

    @Resource(name = "deptService5")
    private DeptService deptService;

    @Override
    public int save(Dept record) { //没有开启事务
        int res1 = deptMapper.insert(record);//插入
        int res2 = deptService.deleteByDeptno(84);//更新
        System.out.println(3 / 0); //模拟出错
        return res1 + res2;
    }

}
