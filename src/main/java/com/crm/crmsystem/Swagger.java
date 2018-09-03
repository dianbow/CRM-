package com.crm.crmsystem;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger {

  @Bean
  public Docket apiConfig() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("api")
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false)
            .select()
            .paths(Predicates.or(PathSelectors.regex("/user/.*")))
            .build();
  }
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("客户管理模块API文档")
            .description("此文档是有关用户模块，增删改查，以及分页查询")
            .version("1.0")//版本
            .contact(new Contact("wudianbo", "http://baidu.com", "wudianbo185@163.com"))
            .license("The Apache License, Version 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .build();
  }


//  @Value("${swagger.show}")
//  private boolean swaggerShow;

//  @Bean
//  public Docket createRestApi() {
//    return new Docket(DocumentationType.SWAGGER_2)
//            .enable(swaggerShow)
//            .apiInfo(apiInfo())
//            .select()
//            .apis(RequestHandlerSelectors.basePackage("com.jieyuechina.bdc.galaxy.controller"))
//            .paths(PathSelectors.any())
//            .build();
//  }
//
//  private ApiInfo apiInfo() {
//    return new ApiInfoBuilder()
//            .title("银河平台-标签API服务")
//            .description("银河平台-标签API服务")
//            .termsOfServiceUrl("http://bdc.jieyuechina.com")
//            .contact(new Contact("", "http://dbc.jieyuechina.com", "xiaoshuichen@jieyuechina.com"))
//            .version("1.0")
//            .build();
//  }
}