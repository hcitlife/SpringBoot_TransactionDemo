package com.hc.mapper;

import com.hc.domain.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptno);

    int insert(Dept record);
}