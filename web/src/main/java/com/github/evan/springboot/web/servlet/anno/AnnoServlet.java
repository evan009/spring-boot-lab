package com.github.evan.springboot.web.servlet.anno;

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

@WebServlet(name = "AnnoServlet", urlPatterns = "/annotaion/servlet/*",
        initParams = {
             @WebInitParam(name = "initParam1", value = "initValue1"),
             @WebInitParam(name = "initParam2", value = "initValue2")
            }
)
public class AnnoServlet extends HttpServlet {

    private String initValue1;
    private String initValue2;
    private ServletContext servletContext;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initValue1 = config.getInitParameter("initParam2");
        initValue2 = config.getInitParameter("initParam2");
        servletContext = config.getServletContext();
        servletContext.log("AnnoServlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        getServletContext().log("AnnoServlet doGet");
        PrintWriter pw = response.getWriter();
        pw.write("AnnoServlet doGet\n");
        pw.write(String.valueOf(request.getAttribute("AnnoFilterAttr")));
        pw.flush();
        pw.close();
    }
}
