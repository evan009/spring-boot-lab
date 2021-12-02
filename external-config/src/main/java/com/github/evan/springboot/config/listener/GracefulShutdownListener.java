package com.github.evan.springboot.config.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc: 优雅关闭  处理容器关闭事件
 * @author: evan
 * @date: 2021-11-19
 */
@Component
@Slf4j
public class GracefulShutdownListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info("ContextClosedEvent graceful shutdown start");

        log.info("ContextClosedEvent graceful shutdown end");
    }
}
