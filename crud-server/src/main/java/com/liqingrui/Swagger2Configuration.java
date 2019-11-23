package com.liqingrui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    @Bean
    public Docket accessToken() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("api")// 定义组
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.liqingrui.controller")) // 拦截的包路径
                .paths(PathSelectors.any())// 拦截的接口路径
                .build() // 创建
                .apiInfo(new ApiInfoBuilder().title("swaggerAPI文档").build()); // 配置说明
    };

}
