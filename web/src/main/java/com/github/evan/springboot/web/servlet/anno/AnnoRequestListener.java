package com.github.evan.springboot.web.servlet.anno;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener(value = "RequestListener")
public class AnnoRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        sre.getServletContext().log("注解方式 requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletContext().log("注解方式 requestInitialized");
    }

}
