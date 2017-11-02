package com.cyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://git.oschina.net/gongxusheng/spring-config-demo
 * @author iechenyb
 * http://localhost:7777/my-client/uat/master
 *http://blog.csdn.net/gongxsh00/article/details/51292200
 *http://localhost:7777/cyb/test/master cyb-test.yml
 *http://localhost:7777/cyb-dev/master 
 *http://localhost:7777/cyb-dev.properties
 *单独启动，不需要eurak服务器！可以访问配置文件目录中的
 *某个配置文件属性。此时的cyb-dev是properties或者yml的文件全名！
 *
 *消息总线安装
 *http://www.rabbitmq.com/install-windows.html 
 *http://www.erlang.org/downloads 
 *http://blog.csdn.net/seven_coder/article/details/50946562
 *http://www.itmuch.com/spring-cloud/spring-cloud-bus-auto-refresh-configuration/
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigServer
@RestController
public class ConfigurationServerApplication {
	@RequestMapping("/")
	public String index(){
		return "/index";
	}
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServerApplication.class, args);
    }
}