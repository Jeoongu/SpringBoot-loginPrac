package com.aledma.loginTest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Login Test Api")
                .version("1.0.0")
                .description("로그인을 테스트 해보기 위해 작성했습니다.")
                .build();
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(apiInfo()).select()
                // controller 파일들이 있는 경로(패키지?) 설정
                .apis(RequestHandlerSelectors.basePackage("com.aledma.loginTest.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }
    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        produces.add("text/plain");
        return produces;
    }


}
