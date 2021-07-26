package com.github.evan.springboot.config.proprity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("config/prority")
public class ConfigProrityController {

    @Value("${external.config.demo.prority}")
    private Integer prority;

    @Value("${external.config.demo.name}")
    private String  name;

    @GetMapping("/v1")
    public Map<String,Object> showConfig(){
        Map<String , Object> result = new HashMap<>();
        result.put("name",name);
        result.put("prority",prority);
        return  result;
    }

}
