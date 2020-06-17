package com.hc.service.impl;

import com.hc.domain.Dept;
import com.hc.mapper.DeptMapper;
import com.hc.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("deptService7")
public class DeptServiceImpl7 implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public int deleteByDeptno(Integer deptno) {
        deptMapper.deleteByPrimaryKey(deptno);
        throw new RuntimeException("数据删除出错"); //模拟出错
    }

    @Resource(name = "deptService7")
    private DeptService deptService;

    @Override
    public int save(Dept record) {
        int res1 = deptMapper.insert(record);//插入
        int res2 = deptService.deleteByDeptno(87);//更新
        System.out.println(3 / 0); //模拟出错
        return res1 + res2;
    }

}
