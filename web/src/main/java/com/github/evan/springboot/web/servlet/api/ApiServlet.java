package com.github.evan.springboot.web.servlet.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ApiServlet extends HttpServlet {

    private String initValue1;
    private String initValue2;
    private ServletContext servletContext;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initValue1 = config.getInitParameter("initParam2");
        initValue2 = config.getInitParameter("initParam2");
        servletContext = config.getServletContext();
        servletContext.log("ApiServlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        getServletContext().log("ApiServlet doGet");
        PrintWriter pw = response.getWriter();
        pw.write("ApiServlet doGet\n");
        pw.write(String.valueOf(request.getAttribute("ApiFilterAttr")));

        pw.flush();
        pw.close();
    }
}
