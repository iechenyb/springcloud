package com.cyb.web.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * 作者 : iechenyb<br>
 * 类描述: 说点啥<br>
 * 创建时间: 2018年3月1日
 */
@Service
@Profile("prod")
public class ProdSendMessage implements Sender {
	Log log = LogFactory.getLog(ProdSendMessage.class);

	public void send() {
		System.out.println(">>>>>>>>Prod Send()<<<<<<<<");
	}
}
