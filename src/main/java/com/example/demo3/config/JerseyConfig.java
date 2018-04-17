package com.example.demo3.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dzuniga on 15/03/2017.
 */
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        packages(true, "com.example.demo3.rest");
    }
}
