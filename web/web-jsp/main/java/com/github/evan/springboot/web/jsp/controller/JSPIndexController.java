package com.github.evan.springboot.web.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("v1")
public class JSPIndexController {

    @RequestMapping("index")
    public String indexJsp (){
        return "index";
    }


    @RequestMapping("rest")
    @ResponseBody
    public String indexRest (){
        return "index";
    }

}

