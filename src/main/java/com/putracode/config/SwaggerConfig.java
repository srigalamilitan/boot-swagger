package com.putracode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by krisna putra on 10/28/2017.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productAPI(){
       return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.putracode"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }
    private ApiInfo metaInfo(){
        return new ApiInfo(
                "Spring boot Swagger",
                "Learning Swagger For Project",
                "1.0",
                "Tearm Of Service",
                new Contact("putracode",
                        "www.putracode.com",
                        "mr.krisna.putra@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html",
                new ArrayList<>()
        );
    }

}
