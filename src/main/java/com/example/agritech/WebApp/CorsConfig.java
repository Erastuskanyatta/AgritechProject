package com.example.agritech.WebApp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return  new WebMvcConfigurerAdapter() {

            public void addCorsMapping(CorsRegistry registry)
            {
                registry.addMapping("/**").allowedMethods("GET", "pOST", "PUT", "DELETE")
                        .allowedOrigins("*").allowedHeaders("*");
            }
        };
    }
}
