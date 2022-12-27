package com.ctseducare.taskbook.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ctseducare.taskbook.yaml.YamlJackson2HttpMessageConverter;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
/*    
    // VIA QUERY PARAMETER
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
          .favorParameter(true)
          .parameterName("mediaType")
          .ignoreAcceptHeader(true)
          .useRegisteredExtensionsOnly(false)
          .defaultContentType(MediaType.APPLICATION_JSON)
          .mediaType("json", MediaType.APPLICATION_JSON)
          .mediaType("xml", MediaType.APPLICATION_XML);
    }
*/
/*
    // VIA HEADER PARAMETER
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
      configurer
        .favorParameter(false)
        .ignoreAcceptHeader(false)
        .useRegisteredExtensionsOnly(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("json", MediaType.APPLICATION_JSON)
        .mediaType("xml", MediaType.APPLICATION_XML);  
    }
*/
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
      configurer
        .favorParameter(false)
        .ignoreAcceptHeader(false)
        .useRegisteredExtensionsOnly(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("json", MediaType.APPLICATION_JSON)
        .mediaType("xml", MediaType.APPLICATION_XML)
        .mediaType("x-yaml", MediaType.valueOf("application/x-yaml"));
    }

}
