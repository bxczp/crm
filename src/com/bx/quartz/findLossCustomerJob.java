package com.bx.quartz;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bx.service.CustomerService;

/**
 * @date 2016年3月30日 findLossCustomer.java
 * @author CZP
 * @parameter
 */
@Component
public class findLossCustomerJob {

	// spring
	// task，可以将它比作一个轻量级的Quartz，而且使用起来很简单，除spring相关的包外不需要额外的包，
	// 而且支持注解和配置文件两种
	@Resource
	private CustomerService customerService;

	// 该方法就是具体的定时任务，方法名 是 自定义的 只要被Scheduled注解即可
	// cron定义 定时任务的执行时间
	// 每分钟执行一次 测试
	// @Scheduled(cron = "0 0/1 * * * ?")
	// 每天凌晨 2 点执行一次
	@Scheduled(cron = "0 0 2 * * ?")
	public void work() {
		customerService.checkCustomerLoss();
	}

}
