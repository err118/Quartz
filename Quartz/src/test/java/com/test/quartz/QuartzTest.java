package com.test.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flyco.job.HelloJob;
import com.flyco.service.QuartzService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:spring-quartz.xml" })
public class QuartzTest {
	@Autowired
	QuartzService quartzService;

	@Test
	public void quartzAdd() {
		quartzService.addJob("helloJob", "helloJobGroup", "trigger1", "triggerGroup", HelloJob.class, "0/5 * * * * ?");
	}
//	@Test
//	public void quartzDelete() {
//		quartzService.removeJob("helloJob", "helloJobGroup", "trigger1", "triggerGroup");
//	}
}
