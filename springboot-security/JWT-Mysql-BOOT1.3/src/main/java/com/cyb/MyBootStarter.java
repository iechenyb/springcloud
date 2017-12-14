package com.cyb;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
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
public class MyBootStarter extends SpringBootServletInitializer {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(MyBootStarter.class);  
    }  
	
	public static void main(String[] args) {
		SpringApplication.run(MyBootStarter.class, args);
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
}
