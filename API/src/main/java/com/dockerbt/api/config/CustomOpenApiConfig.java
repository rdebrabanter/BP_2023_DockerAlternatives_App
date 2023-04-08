package com.dockerbt.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomOpenApiConfig
{
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .version("1.1")
                        .license(new License()
                                .name("DockerBT API"))
                        .termsOfService("These are the terms and conditions.")
                        .title("DockerBT API")
                        .description("The REST API services for docker thesis."));
    }
}
