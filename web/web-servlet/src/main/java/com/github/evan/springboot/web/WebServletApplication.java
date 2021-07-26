package com.github.evan.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.github.evan.springboot.web.servlet.anno")
public class WebServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServletApplication.class, args);
    }

}
