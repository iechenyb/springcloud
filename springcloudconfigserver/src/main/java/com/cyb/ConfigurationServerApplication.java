package com.cyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

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
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigurationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServerApplication.class, args);
    }
}