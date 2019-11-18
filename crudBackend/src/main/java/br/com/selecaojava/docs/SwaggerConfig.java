package br.com.selecaojava.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDoc(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.selecaojava.controller"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaData());

    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Selecao Java Stefanini")
                .description("Desafio Java")
                .version("1.0")
                .contact(new Contact("Claudio Henrique","http://www.claudio.com.br","claudio.blz25@gmail.com"))
                .build();
    }

}
