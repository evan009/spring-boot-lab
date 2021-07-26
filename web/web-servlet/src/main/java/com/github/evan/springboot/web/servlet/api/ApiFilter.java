package com.github.evan.springboot.web.servlet.api;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

public class ApiFilter implements Filter {

    private ServletContext servletContext;

    @Override
    public void init(FilterConfig config) throws ServletException {
        servletContext = config.getServletContext();
        servletContext.log("ApiFilter init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        servletContext.log("ApiFilter doFilter");
        req.setAttribute("ApiFilterAttr", "ApiFilterAttr");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        servletContext.log("ApiFilter destroy");
    }

}
