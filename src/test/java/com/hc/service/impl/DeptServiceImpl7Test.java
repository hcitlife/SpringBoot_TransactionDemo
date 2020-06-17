package com.hc.service.impl;

import com.hc.domain.Dept;
import com.hc.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DeptServiceImpl7Test {

    @Resource(name = "deptService7")
    private DeptService deptService;

    @Test
    void insert() {
        Dept dept = Dept.builder()
                .dname("bb")
                .loc("bbbbbbbbb").build();
        int insert = deptService.save(dept);
        System.out.println(insert);
    }

}