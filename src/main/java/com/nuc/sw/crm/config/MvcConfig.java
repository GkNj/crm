package com.nuc.sw.crm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html");
        registry.addViewController("/dictionary/addDictionary.html");
        registry.addViewController("/opportunity/opportunityeditor.html");
        registry.addViewController("/opportunity/createopportunity.html");
        registry.addViewController("/opportunity/opportunitymanage.html");
        registry.addViewController("/opportunity/opportunitypoint.html");
        registry.addViewController("/opportunity/createplan.html");
        registry.addViewController("/service/create.html");

        registry.addRedirectViewController("/index","/templates/index.html");
    }

}