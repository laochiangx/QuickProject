package com.project.QuickProject.system.mapper;

import com.project.QuickProject.system.entity.SysMenu;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @github:https://github.com/Jimmey-Jiang
 * @Author: Jimmey-Jiang
 * @E-mail:jimmey-jiang@foxmail.com
 * @Date: 2021/3/1 14:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class SysMenuMapperTest {

    @Autowired
    public SysMenuMapper sysMenuMapper;

    @Autowired
    public SysUserMapper sysUserMapper;
    @Test
    public void SysMenuMapperTest2() {

    }
    @Test
    public void getsysMenuTest() {
        System.out.println(sysMenuMapper.selectById(1));
    }

    @Test
    public void getSysUserTest() {
        System.out.println(sysUserMapper.selectById(1));
    }
}
