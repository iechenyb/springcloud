package com.example.jwtauth.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	Log log = LogFactory.getLog(SwaggerConfig.class);
    @Bean
    public Docket createRestApi() {
    	log.info("create api!");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any()) // 对所有api进行监控
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
    	log.info("api Info!");
        return new ApiInfoBuilder()
                .title("swagger2")
                .description("Spring Boot中使用Swagger2构建RESTful APIs")
                .termsOfServiceUrl("xsc19850920@163.com")
                .version("1.0")
                .build();
    }
}
