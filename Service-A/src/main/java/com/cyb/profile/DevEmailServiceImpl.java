package com.cyb.profile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月11日
 */
@Service
@Profile("dev") //开发环境的时候.
public class DevEmailServiceImpl implements EmailService{
	Log log = LogFactory.getLog(DevEmailServiceImpl.class);
	public void send() {
		log.info("开发环境执行！");
	}
}
