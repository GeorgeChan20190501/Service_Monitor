package com.cognizant.ams.scheduler;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.cognizant.ams.service.ServiceMonitorService;

@Component
@EnableScheduling
public class SchedulingConf implements  SchedulingConfigurer{
 
    public static String cron;
    @Autowired
    private ServiceMonitorService serviceMonitorService;
    @Autowired
    private ServiceMonitorScheduler serviceMonitorScheduler;
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //项目部署时，会在这里执行一次，从数据库拿到cron表达式
        cron =serviceMonitorService.getScheduleConfigInfo();
 
       Runnable task = new Runnable() {
           @Override
           public void run() {
        	   serviceMonitorScheduler.SMonitorScheduler();
           }
       };
       Trigger trigger = new Trigger() {
           @Override
           public Date nextExecutionTime(TriggerContext triggerContext) {
              CronTrigger trigger = new CronTrigger(cron);
              Date nextExec = trigger.nextExecutionTime(triggerContext);
              return nextExec;
           }
       };
       taskRegistrar.addTriggerTask(task, trigger);
    }
 
}