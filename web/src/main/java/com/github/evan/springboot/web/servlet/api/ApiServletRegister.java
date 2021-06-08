package com.github.evan.springboot.web.servlet.api;


import javax.servlet.DispatcherType;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ApiServletRegister {


    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setName("ApiServlet");
        servletRegistrationBean.setServlet(new ApiServlet());
        servletRegistrationBean.addUrlMappings("/api/servlet/*");
        servletRegistrationBean.addInitParameter("initParam1","initValue1");
        servletRegistrationBean.addInitParameter("initParam2","initValue2");
        servletRegistrationBean.setAsyncSupported(true);
        return  servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("ApiFilter");
        filterRegistrationBean.setFilter(new ApiFilter());
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,DispatcherType.FORWARD);
        filterRegistrationBean.addUrlPatterns("/api/servlet/*");
        filterRegistrationBean.addInitParameter("initParam1","initValue1");
        filterRegistrationBean.addInitParameter("initParam2","initValuee2");
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE+2);
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean apiContextListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new ApiContextListener());
        return servletListenerRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean apiRequestListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new ApiRequestListener());
        return servletListenerRegistrationBean;
    }

}
