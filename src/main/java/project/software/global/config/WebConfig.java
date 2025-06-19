package project.software.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedOriginPatterns("*")
            .allowedHeaders("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PATCH")
            .exposedHeaders("Authorization", "RefreshToken", "*")
            .allowCredentials(false);
    }
}
