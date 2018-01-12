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
@Profile("prod") //开发环境的时候.
public class ProdEmailServiceImpl implements EmailService{
	Log log = LogFactory.getLog(ProdEmailServiceImpl.class);

	public void send() {
		log.info("生产环境执行！");
	}
}
