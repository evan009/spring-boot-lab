package com.github.evan.springboot.web.servlet.anno;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "AnnoFilter",
            urlPatterns = "/annotaion/servlet/*",
        initParams = {
        @WebInitParam(name = "initParam1", value = "initValue1"),
        @WebInitParam(name = "initParam2", value = "initValue2")
})
public class AnnoFilter implements Filter {

    private ServletContext servletContext;

    @Override
    public void init(FilterConfig config) throws ServletException {
        servletContext = config.getServletContext();
        servletContext.log("AnnoFilter init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        servletContext.log("AnnoFilter doFilter");
        req.setAttribute("AnnoFilterAttr","AnnoFilterData");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        servletContext.log("AnnoFilter destroy");
    }

}
