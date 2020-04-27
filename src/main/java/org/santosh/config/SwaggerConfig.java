package org.santosh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring MVC Rest API",
                " Spring MVC Spring Boot 2 Application",
                "1.0",
                null,
                 new Contact("Santoshkumar Engandhula", "https://www.linkedin.com/in/santoshkumar-engandhula-116a4468/", "santosh.kumar02@rediffmail.com"), null, null,
                 Collections.emptyList());
    }
}
