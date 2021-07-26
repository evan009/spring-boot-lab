package com.github.evan.springboot.web.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.evan.springboot.web.mvc.vo.UserVO;

/**
 * @Desc: 内容协商示例
 * @author: evan
 * @date: 2021-06-07 16:05
 */
@RestController
@RequestMapping("config/content/")
public class ContentNegotiationExample {


    /**
     * 扩展名 > format请求参数 > HTTP的Accept请求头。
     */

    @Autowired
    private UserVO userVO;

    @RequestMapping("/v1/negotiation")
    public UserVO negotiation() {
        userVO.setDesc("内容协商 可以处理所有请求");
        return userVO;
    }

    @GetMapping(value = "/v1/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserVO json() {
        userVO.setDesc("只处理GET请求的 application/json");
        return userVO;
    }

    @GetMapping(value = "/v1/xml",
            produces = MediaType.APPLICATION_XML_VALUE)
    public UserVO xml() {
        userVO.setDesc("只处理GET请求的 application/xml");
        return userVO;
    }

}
