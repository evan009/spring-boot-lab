package com.github.evan.springboot.config.external;

import com.github.evan.springboot.config.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("external/prop/javaApi")
public class PropGetByJavaApiController implements EnvironmentAware {

    private User user;

    @GetMapping("/v1")
    public User javaApi(){
        return  user;
    }

    @Override
    public void setEnvironment(Environment environment) {
        user = new User();
        user.setIdCardNo(environment.getProperty("user.idCardNo",String.class));
        user.setName(environment.getProperty("user.name",String.class));
        user.setAge(environment.getProperty("user.age",Integer.class));
    }
}
