package com.test.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.ICostDao;
import com.test.pojo.Cost;

public class TestCostDAO {

	@Test
	public void test1() {
		String conf = "/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);

		ICostDao costDao = (ICostDao) ac.getBean("hibernateCostDAO");
		// costDao.deleteById(122);
		List<Cost> list = costDao.findAll();
		for (Cost c : list) {
			System.out.println(c.getId() + " " + c.getName());
		}
	}
}
