package com.cyb.profile;

/**
 *作者 : iechenyb<br>
 *类描述: 条件注入，环境不同注入的方式不同。
 *根据该规则，可以定义生成不同的配置文件的属性bean<br>
 *创建时间: 2018年1月11日
 */
public interface EmailService {
	 /**发送邮件*/
    public void send();
}
