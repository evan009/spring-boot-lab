package com.github.evan.springboot.config.external;

import com.github.evan.springboot.config.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("external/prop/xml")
public class PropGetByXmlController {

    @Autowired
    @Qualifier(value="xmlUser")
    private User xmlUser;

    @Autowired
    @Qualifier(value="xmlUserProd")
    private User xmlUserProd;



    @GetMapping("/v1")
    public Map<String, Object> xml(){
        Map<String,Object> result =new HashMap<>();
        result.put("xmlUser",xmlUser);
        result.put("xmlUserProd",xmlUserProd);
        return  result;
    }

}
