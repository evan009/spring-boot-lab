package com.github.evan.springboot.web.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("jsp/v1")
public class JspController {

    @GetMapping("index")
    public String index(){
        return "index";
    }

//
//    @GetMapping("index/attr")
//    public ModelAndView indexAttr(HttpServletRequest request){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("index");
//        mv.addObject("attr","mvAttr");
//        request.setAttribute("attr","requestAttr");
//        request.getSession().setAttribute("arrt","sessionAttr");
//        return mv;
//    }


}
