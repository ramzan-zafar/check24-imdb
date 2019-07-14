package com.check24.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration component for Swagger setup.
 * @author ramzanzafar
 */
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@Configuration
public class SwaggerConfig {
    private static final String BASE_PACKAGE = "com.check24";

    @Value("${plutus.api.title}")
    private String apiTitle;

    @Value("${plutus.api.details}")
    private String apiDetails;

    @Value("${plutus.api.license}")
    private String apiLicense;

    @Value("${plutus.api.version}")
    private String apiVersion;

    @Value("${plutus.api.contact.name}")
    private String apiContactName;

    @Value("${plutus.api.contact.link}")
    private String apiContactLink;

    @Value("${plutus.api.contact.mail}")
    private String apiContactMail;

    /**
     * Inits Swagger {@link Docket} bean with injected properties from file.
     * @return the {@link Docket} bean.
     */
    @Bean
    public Docket activityApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)).paths(PathSelectors.any())
                .build().apiInfo(plutusApiInfo());
    }

    private ApiInfo plutusApiInfo() {
        return new ApiInfoBuilder().title(apiTitle).version(apiVersion).description(apiDetails).contact(getContactInfo()).license(apiLicense).build();
    }

    private Contact getContactInfo() {
        return new Contact(apiContactName, apiContactLink, apiContactMail);
    }
}
