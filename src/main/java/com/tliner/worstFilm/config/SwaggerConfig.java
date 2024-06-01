package com.tliner.worstFilm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
            .title("Intervalo de prêmios")
            .description(" API RESTful para possibilitar a leitura da lista de indicados e vencedores" +
                                " da categoria Pior Filme do Golden Raspberry Awards.")
            .version("1.0"))
            .components(new Components()
            .addSecuritySchemes("basicScheme",
            new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))
        );
    }
}
