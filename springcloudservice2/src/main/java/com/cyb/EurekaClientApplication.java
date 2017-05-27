package com.cyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 *
 */
@EnableDiscoveryClient //ͨ����ע�⣬ʵ�ַ����֣�ע��
@SpringBootApplication //implements EmbeddedServletContainerCustomizer
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

	/*public void customize(ConfigurableEmbeddedServletContainer c) {
		c.setPort(8886);
	}*/
}