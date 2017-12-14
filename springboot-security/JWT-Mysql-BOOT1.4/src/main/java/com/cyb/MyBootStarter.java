package com.cyb;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.dubbo.test.EchoService;
import com.cyb.service.dubbo.DubboService;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2017年12月13日
 */
//// 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
@ServletComponentScan
@EnableTransactionManagement
@SpringBootApplication
@RestController
public class MyBootStarter extends SpringBootServletInitializer implements CommandLineRunner {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(MyBootStarter.class);  
    }  
	public  static ConfigurableApplicationContext context;
	
	public static ConfigurableApplicationContext getContext() {
		return context;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext run =SpringApplication.run(MyBootStarter.class, args);
		DubboService abc = run.getBean(DubboService.class);
		System.out.println("dubboservice="+abc);
		System.out.println("dubboservice.echoService="+abc.echoService);
        System.out.println(abc.echoService.echo("abccc"));
      
	}

	 //其中 dataSource 框架会自动为我们注入
    @Bean
    public PlatformTransactionManager txManagerDataSource(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    /**
     * 注入sessionfatory
     * @return
     */
    @SuppressWarnings("deprecation")
	@Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

	@Override
	public void run(String... arg0) throws Exception {
		System.err.println("服务调用者------>>启动完毕");
	}
}
