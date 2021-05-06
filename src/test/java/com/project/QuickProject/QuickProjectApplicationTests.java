package com.project.QuickProject;

import com.project.QuickProject.system.entity.SysMenu;
import com.project.QuickProject.system.mapper.SysMenuMapper;
import com.project.QuickProject.system.mapper.SysUserMapper;
import com.project.QuickProject.system.service.ISysMenuService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Component
class QuickProjectApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	public ISysMenuService SysMenuService;
	@Autowired
	public SysMenuMapper sysMenuMapper;

	@Autowired
	public SysUserMapper sysUserMapper;
	@Test
	public void SysMenuMapperTest2() {

	}


	@Test
	public void getSysUserTest() {
		System.out.println(sysUserMapper.selectById(1));
	}
}
