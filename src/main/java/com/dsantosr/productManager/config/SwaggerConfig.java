package com.dsantosr.productManager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("Produtos API")
                        .version("v1")
                        .description("API de gestão de produtos")
                        .contact(new Contact()
                                .name("Daniel dos Santos")
                                .email("danielsantrodrigues42@gmail.com")
                        )
                        .termsOfService("https://api.triboraizes.com.br/produto-api/terms")
                        .license(new License().name("Apache 2.0").url("https://api.triboraizes.com.br/produto-api"))
        );
    }
}