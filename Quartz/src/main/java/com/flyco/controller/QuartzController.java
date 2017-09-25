package com.flyco.controller;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.alibaba.fastjson.JSONObject;
import com.flyco.job.HelloJob;
import com.flyco.model.Result;
import com.flyco.service.QuartzService;

@Controller
public class QuartzController {
	@Autowired
	QuartzService quartzService;
	final static Logger logger = LoggerFactory.getLogger(QuartzController.class);

	@RequestMapping(value = "/addJob", method = RequestMethod.GET)
	public @ResponseBody Result addJob() {
		quartzService.addJob("helloJob", "helloJobGroup", "trigger1", "triggerGroup", HelloJob.class, "0/5 * * * * ?");
		
		return Result.successMessage("成功", "");
	}
	@RequestMapping(value = "/pauseJob", method = RequestMethod.GET)
	public @ResponseBody Result pauseJob() {
		quartzService.pauseJob("helloJob", "helloJobGroup");
		return Result.successMessage("成功", "");
	}
	@RequestMapping(value = "/resumeJob", method = RequestMethod.GET)
	public @ResponseBody Result resumeJob() {
		quartzService.resumeJob("helloJob", "helloJobGroup");
		return Result.successMessage("成功", "");
	}
	@RequestMapping(value = "/removeJob", method = RequestMethod.GET)
	public @ResponseBody Result removeResult () {
		quartzService.removeJob("helloJob", "helloJobGroup", "trigger1", "triggerGroup");
		return Result.successMessage("成功", "");
	}
	@RequestMapping(value = "/modifyJob", method = RequestMethod.GET)
	public @ResponseBody Result modifyResult () {
		quartzService.updateScheduleJob("trigger1", "triggerGroup", "0/3 * * * * ?");
		return Result.successMessage("成功", "");
	}
}
