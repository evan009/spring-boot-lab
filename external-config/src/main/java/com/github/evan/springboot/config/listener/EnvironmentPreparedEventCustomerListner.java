package com.github.evan.springboot.config.listener;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义事件监听器  {@link ApplicationEnvironmentPreparedEvent}
 * @author evan
 */
@Slf4j
public class EnvironmentPreparedEventCustomerListner implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment env  = event.getEnvironment();

        MutablePropertySources mutablePropertySources = env.getPropertySources();
        log.info("After MutablePropertySources:{}", mutablePropertySources);
        Map<String, Object> customerExternalConfig = new HashMap<>();
        customerExternalConfig.put("server.port",8080);
        customerExternalConfig.put("external.config.demo.prority", -1);
        customerExternalConfig.put("external.config.demo.name", "ApplicationEnvironmentPreparedEvent mutablePropertySources.addFirst(propertySource)");
        MapPropertySource propertySource = new MapPropertySource("listnerExternalConfig", customerExternalConfig);
        mutablePropertySources.addFirst(propertySource);
        log.info("Before MutablePropertySources:{}", mutablePropertySources);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
