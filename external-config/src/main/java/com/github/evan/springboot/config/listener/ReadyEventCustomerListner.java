package com.github.evan.springboot.config.listener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义事件监听器  {@link ApplicationReadyEvent}
 * @author evan
 */
@Slf4j
public class ReadyEventCustomerListner implements ApplicationListener<ApplicationReadyEvent>, Ordered {


    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("applicationReadyEvent:{}",applicationReadyEvent);
        log.info("applicationReadyEvent source:{}",applicationReadyEvent.getSource());
        log.info("applicationReadyEvent args:{}", Arrays.asList(applicationReadyEvent.getArgs()));
        log.info("applicationReadyEvent SpringApplication:{}",applicationReadyEvent.getSpringApplication());
        log.info("applicationReadyEvent ApplicationContext:{}",applicationReadyEvent.getApplicationContext());
        ConfigurableApplicationContext  applicationContext =  applicationReadyEvent.getApplicationContext();
        log.info("ApplicationContext name:",applicationContext.getApplicationName());
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        log.info("event PropertySources:{}",environment.getPropertySources());
        log.info("event SystemEnvironment:{}",environment.getSystemEnvironment());
        log.info("event SystemProperties:{}",environment.getSystemProperties());
        log.info("event server.port:{}",environment.getProperty("server.port"));

    }
}
