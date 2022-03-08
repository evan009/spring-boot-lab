package com.github.evan.springboot.config.listener;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义事件监听器  {@link ApplicationEnvironmentPreparedEvent}
 * @author evan
 */
@Slf4j
public class EnvironmentPreparedEventCustomerListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment env  = event.getEnvironment();

        MutablePropertySources mutablePropertySources = env.getPropertySources();
        log.info("After MutablePropertySources:{}", mutablePropertySources);
        Map<String, Object> customerExternalConfig = new HashMap<>();
        customerExternalConfig.put("server.port",8080);
        customerExternalConfig.put("external.config.demo.priority", -1);
        customerExternalConfig.put("external.config.demo.name", "ApplicationEnvironmentPreparedEvent mutablePropertySources.addFirst(propertySource)");
        MapPropertySource propertySource = new MapPropertySource("listenerExternalConfig", customerExternalConfig);
        mutablePropertySources.addFirst(propertySource);
        log.info("Before MutablePropertySources:{}", mutablePropertySources);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
