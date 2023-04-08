package com.dockerbt.api.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOriginPattern("*");
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.setExposedHeaders(List.of("total-count"));
        config.setAllowedMethods( new ArrayList<>() {{
            add("GET");
            add("POST");
            add("PUT");
            add("DELETE");
        }});
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
