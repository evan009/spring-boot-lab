package com.github.evan.springboot.web.servlet.api;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener(value = "ApiContextListener")
public class ApiContextListener implements ServletContextListener{


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("API方式 启动容器 加载需要的属性配置文件，初始化数据库连接池等");

        sce.getServletContext().log("API方式 contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("API方式 关闭容器 关闭数据库连接池等");

        sce.getServletContext().log("API方式 contextDestroyed");
    }

}
