package com.github.evan.springboot.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import com.github.evan.springboot.config.listener.EnvironmentPreparedEventCustomerListener;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.github.evan.springboot.config.servlet")
@Slf4j
@ImportResource(locations = {"META-INF/spring/beanContent.xml", "META-INF/spring/beanContent-prod.xml",
    "META-INF/spring/beanContent-test.xml"})
public class ExternalConfigApplication implements EnvironmentAware {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ExternalConfigApplication.class);

        // 添加属性外部化配置
        Map<String, Object> javaCodeProperties = new HashMap<>();
        javaCodeProperties.put("external.config.demo.priority", 17);
        javaCodeProperties.put("external.config.demo.name",
            "Default properties (specified by setting SpringApplication.setDefaultProperties)");
        application.setDefaultProperties(javaCodeProperties);
        // 激活Profile
        application.setAdditionalProfiles("prod");

        // 通过Java方式添加监听器
        EnvironmentPreparedEventCustomerListener preparedEventCustomerListner =
            new EnvironmentPreparedEventCustomerListener();
        application.addListeners(preparedEventCustomerListner);
        application.run(args);
    }

    @Override
    public void setEnvironment(Environment environment) {
        String[] activeProfiles = environment.getActiveProfiles();
        log.info("activeProfiles:{}", activeProfiles);

        Integer prority = environment.getProperty("external.config.demo.prority", Integer.class);
        String name = environment.getProperty("external.config.demo.name", String.class);
        log.info("prority:{} name:{}", prority, name);

        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment env = ConfigurableEnvironment.class.cast(environment);
            MutablePropertySources mutablePropertySources = env.getPropertySources();
            log.info("After MutablePropertySources:{}", mutablePropertySources);

            Map<String, Object> customerExternalConfig = new HashMap<>();
            customerExternalConfig.put("server.port", 8081);
            customerExternalConfig.put("external.config.demo.prority", 0);
            customerExternalConfig.put("external.config.demo.name",
                "EnvironmentAware mutablePropertySources.addFirst(propertySource)");
            MapPropertySource propertySource = new MapPropertySource("customerExternalConfig", customerExternalConfig);
            mutablePropertySources.addFirst(propertySource);
            log.info("Before MutablePropertySources:{}", mutablePropertySources);

        }
    }
}
