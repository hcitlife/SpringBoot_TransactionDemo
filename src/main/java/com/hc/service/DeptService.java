package com.hc.service;

import com.hc.domain.Dept;
public interface DeptService{
    int deleteByDeptno(Integer deptno);

    int save(Dept record);
}
