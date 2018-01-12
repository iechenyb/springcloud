package com.cyb.web;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.event.ClientApplicationStatusChangedEvent;
import de.codecentric.boot.admin.notify.AbstractStatusChangeNotifier;
/**
 *作者 : iechenyb<br>
 *类描述: https://github.com/yinjihuan/spring-cloud/blob/master/fangjia-common/src/main/java/com/fangjia/common/util/DingDingMessageUtil.java<br>
 *创建时间: 2018年1月9日
 */
@Component("myNotifier") 
public class DingDingNotifier extends AbstractStatusChangeNotifier{
	Log log = LogFactory.getLog(getClass());
    private Expression text;
    
    @SuppressWarnings("unused")
	@Autowired
    private JavaMailSender sender;
    
    private final SpelExpressionParser parser = new SpelExpressionParser();

    public DingDingNotifier() {
        this.text = this.
        		parser.
        		parseExpression("iechenyb:#{application.name} (#{application.id})\nstatus changed from #{from.status} to #{to.status}\n\n#{application.healthUrl}", ParserContext.TEMPLATE_EXPRESSION);
    }

    protected void doNotify(ClientApplicationEvent event) throws Exception {
        EvaluationContext context = new StandardEvaluationContext(event);
        String text = this.text.getValue(context, String.class);
        log.info("发送邮件！\n*************\n"+text+"\n*******************");
        if (event instanceof ClientApplicationStatusChangedEvent) {
			ClientApplicationStatusChangedEvent statusChange = (ClientApplicationStatusChangedEvent) event;
			String from = statusChange.getFrom().getStatus();
			String to = statusChange.getTo().getStatus();
			log.info(from+"++++++++++->"+to);
			/*return Arrays.binarySearch(ignoreChanges, from + ":" + to) < 0
					&& Arrays.binarySearch(ignoreChanges, "*:" + to) < 0
					&& Arrays.binarySearch(ignoreChanges, from + ":*") < 0;*/
		}
        /*SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("383065059@qq.com");
        message.setTo("383065059@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText(text);
        sender.send(message);*/
    }

    public void setText(String text) {
        this.text = this.parser.parseExpression(text, ParserContext.TEMPLATE_EXPRESSION);
    }

    public String getText() {
        return this.text.getExpressionString();
    }
}