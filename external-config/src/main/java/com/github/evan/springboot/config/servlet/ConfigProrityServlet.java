package com.github.evan.springboot.config.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSONObject;

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
        result.put("priority", prority);
        printWriter.write(result.toJSONString());
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
