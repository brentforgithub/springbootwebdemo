package com.brent.demo;

import com.alibaba.fastjson.JSON;
import com.brent.demo.dao.NameDemoMapper;
import com.brent.demo.mode.po.NameDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private NameDemoMapper nameDemoMapper;

	@Test
	void contextLoads() {
		NameDemo  nameDemo = nameDemoMapper.selectByPrimaryKey(1);
		System.out.println(JSON.toJSON(nameDemo));
	}

}
