package com.larry.mvcsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.IOException;

@Configuration
@SpringBootApplication
public class MvcsampleApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MvcsampleApplication.class, args);

        System.out.println("Press ENTER to exit.");
        if (System.in.read() == 10) System.exit(0);
    }

    @Bean
    public WebMvcRegistrations webMvcRegistrationsHandlerMapping() {
        return new WebMvcRegistrations() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new ExtendedRequestMappingHandlerMapping();
            }
        };
    }

//    @Bean
//    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//        RequestMappingHandlerMapping handlerMapping = new ExtendedRequestMappingHandlerMapping();
//        handlerMapping.setOrder(0);
//        return handlerMapping;
//    }
}
