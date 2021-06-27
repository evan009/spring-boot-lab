package com.github.evan.springboot.auto.configuration;

import com.github.evan.springboot.auto.model.User;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(name = "user")
@ConditionalOnProperty(prefix = "user",value = "enable", havingValue = "true")
@AutoConfigureAfter(EmbeddedWebServerFactoryCustomizerAutoConfiguration.class)
public class UserAutoConfigUration {

    @Bean
    @ConfigurationProperties(prefix = "user")
    public User user(){
        return new User();
    }

}
