package com.noirix.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    public static final String CINEMA_API = "Cinema API";
    public static final String API_FOR_WORKING_WITH_CINEMA = "API for working with Cinema";
    public static final String VERSION = "2.0";
    public static final String APACHE_LICENSE_2_0 = "Apache License 2.0";
    public static final String HTTPS_WWW_APACHE_ORG_LICENSES_LICENSE_2_0_HTML = "https://www.apache.org/licenses/LICENSE-2.0.html";
    public static final String DEGTYARENKO_OLGA = "Degtyarenko Olga";
    public static final String OLGA_DEGTYARENKO_1_GMAIL_COM = "olga.degtyarenko1@gmail.com";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title(CINEMA_API)
                .description(API_FOR_WORKING_WITH_CINEMA)
                .version(VERSION)
                .contact(apiContact())
                .license(apiLicence());
    }

    private License apiLicence() {
        return new License()
                .name(APACHE_LICENSE_2_0)
                .url(HTTPS_WWW_APACHE_ORG_LICENSES_LICENSE_2_0_HTML);
    }

    private Contact apiContact() {
        return new Contact()
                .name(DEGTYARENKO_OLGA)
                .email(OLGA_DEGTYARENKO_1_GMAIL_COM);
    }
}
