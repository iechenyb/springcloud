package com.cyb.condition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月11日
 */
public class LinuxCondition implements Condition{
	Log log = LogFactory.getLog(LinuxCondition.class);

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		 return context.getEnvironment().getProperty("os.name").contains("Linux");
	}
}
