package com.github.evan.springboot.config.external;

import com.github.evan.springboot.config.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("external/prop/anno")
public class PropGetByAnnoController {

    @Value("${user.idCardNo:'默认身份证'}")
    private String idCardNo;
    @Value("${user.name:'默认姓名'}")
    private String name;
    @Value("${user.age:18}")
    private Integer age;

    @GetMapping("/v1")
    public User anno(){
        User user = new User();
        user.setIdCardNo(idCardNo);
        user.setName(name);
        user.setAge(age);
        return  user;
    }

}
