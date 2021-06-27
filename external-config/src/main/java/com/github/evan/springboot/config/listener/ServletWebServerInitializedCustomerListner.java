package com.github.evan.springboot.config.listener;

import java.util.Arrays;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义事件监听器  {@link ServletWebServerInitializedEvent}
 * @author evan
 */
@Slf4j
public class ServletWebServerInitializedCustomerListner implements ApplicationListener<ServletWebServerInitializedEvent>, Ordered {


    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }


    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
       WebServer webServer = event.getWebServer();
       log.info("webServer port:{}",webServer.getPort());
    }
}
