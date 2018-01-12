package com.cyb.condition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月11日
 */
public class WindowsServiceImpl implements ListService{
	Log log = LogFactory.getLog(WindowsServiceImpl.class);

	public String showListCmd() {
		return "dir";
	}
}
