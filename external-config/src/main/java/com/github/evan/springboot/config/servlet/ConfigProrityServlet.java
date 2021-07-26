package com.github.evan.springboot.config.servlet;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigProrityServlet", value = "/servlet/",
        initParams = {
                @WebInitParam(name = "external.config.demo.prority", value = "6"),
                @WebInitParam(name = "external.config.demo.name", value = "Servlet Config Init Params")
        })
public class ConfigProrityServlet extends HttpServlet {


    @Value("${external.config.demo.prority}")
    private Integer prority;

    @Value("${external.config.demo.name}")
    private String  name;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        JSONObject result = new JSONObject();
        result.put("name", name);
        result.put("prority", prority);
        printWriter.write(result.toJSONString());
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
