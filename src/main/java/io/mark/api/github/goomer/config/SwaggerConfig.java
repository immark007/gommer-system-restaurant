package io.mark.api.github.goomer.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Goomer RESTful API")
                        .version("v1")
                        .description("API para gerenciamento de restaurantes e produtos")
                        .termsOfService("https://goomer.com.br/terms")
                        .contact(new Contact()
                                .name("Suporte Goomer")
                                .url("https://goomer.com.br/support")
                                .email("suporte@goomer.com.br"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")));
    }
}