package com.hc.service.impl;

import com.hc.domain.Dept;
import com.hc.mapper.DeptMapper;
import com.hc.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("deptService12")
public class DeptServiceImpl12 implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public int deleteByDeptno(Integer deptno) {
        int res = deptMapper.deleteByPrimaryKey(deptno);
        System.out.println(2 / 0);
        return res;
    }

    @Resource(name = "deptService12")
    private DeptService deptService;

    @Override
    @Transactional
    public int save(Dept record) {
        int res1 = deptMapper.insert(record);//插入
        int res2 = 0;//更新
        try {//delete执行前，保存一个savePoint，如果delete异常，则回滚到savePoint，否则等待和save一起提交事务
            res2 = deptService.deleteByDeptno(88);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(3 / 0); //模拟出错,如果出错insert和delete会一起回滚
        return res1 + res2;
    }

}
