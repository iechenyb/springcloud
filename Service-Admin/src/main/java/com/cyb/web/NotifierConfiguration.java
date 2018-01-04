package com.cyb.web;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.netflix.governator.annotations.binding.Primary;

//import com.netflix.governator.annotations.binding.Primary;

import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;

/**
 * 
 * @Title: 为监控的服务添加邮件通知
 * @author iechenyb  
 * @date 2017年7月27日17:01:22 
 * @version V1.0
 */

@Configuration
@EnableScheduling
public class NotifierConfiguration {
	
    @Autowired
    private Notifier notifier;

    //服务上线或者下线都通知
    private String[] reminderStatuses = { "DOWN","OFFLINE" };
    
    @Bean
    @Primary
    public RemindingNotifier remindingNotifier() {
        RemindingNotifier remindingNotifier = new RemindingNotifier(notifier);
        //设定时间，5分钟提醒一次
        remindingNotifier.setReminderPeriod(TimeUnit.MINUTES.toMillis(30)); 
        //设定监控服务状态，状态改变为给定值的时候提醒
        remindingNotifier.setReminderStatuses(reminderStatuses);
        return remindingNotifier;
    }
    /**
     * 
     *作者 : iechenyb<br>
     *方法描述: 6秒调度一次<br>
     *创建时间: 2017年7月15日
     */
    @Scheduled(fixedRate = 6000L) 
    public void remind() {
        remindingNotifier().sendReminders();
    }
}