package com.github.evan.springboot.embedded.servlet;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JettyServletWebServerConfig {


    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(){
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setPort(8091);
        return factory;
    }

}
