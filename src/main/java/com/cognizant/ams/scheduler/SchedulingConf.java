package com.cognizant.ams.scheduler;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.cognizant.ams.bean.SmConfig;
import com.cognizant.ams.common.utils.SpringUtil;
import com.cognizant.ams.service.ServiceMonitorService;

@Component
@EnableScheduling
public class SchedulingConf implements SchedulingConfigurer {

	public static String cron;
	public static String cron2;
	@Autowired
	private ServiceMonitorService serviceMonitorService;
	
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		// 项目部署时，会在这里执行一次，从数据库拿到cron表达式
		List<SmConfig> list = serviceMonitorService.getScheduleConfigInfo();
		System.out.println(list.size());
		for (SmConfig s : list) {
			scheduledTaskRegistrar.addTriggerTask(getRunnable(s), getTrigger(s));
		}
	}

	public Runnable getRunnable(SmConfig smConfig) {
		return new Runnable() {
			@Override
			public void run() {
				Class<?> clazz;
				try {
					clazz = Class.forName(smConfig.getCval4());
					Object bean = (Object) SpringUtil.getBean(clazz);
					Method method = clazz.getMethod("run",new Class[] {});
					method.invoke(bean);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
	}

	/**
	 * Trigger
	 * 
	 * @param scheduleConfig
	 * @return
	 */
	private Trigger getTrigger(SmConfig smConfig) {
		return new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				CronTrigger trigger = new CronTrigger(smConfig.getCval1());
				Date nextExec = trigger.nextExecutionTime(triggerContext);
				return nextExec;
			}
		};

	}

}