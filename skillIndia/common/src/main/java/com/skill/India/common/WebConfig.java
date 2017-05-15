
package com.skill.India.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;




@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

      
  

 
    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/endpoints").setViewName("endpoints");
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/logoffUser").setViewName("logoffUser");
        registry.addViewController("/login").setViewName("login");
                
    }
    
    
}
