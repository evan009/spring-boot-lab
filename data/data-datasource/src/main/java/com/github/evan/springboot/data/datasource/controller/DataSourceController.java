package com.github.evan.springboot.data.datasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("datasource")
public class DataSourceController {

    @Autowired
    private DataSource dataSource;


    @GetMapping("database/info")
    public Map<String,Object> da() throws SQLException {
        Connection connection = dataSource.getConnection();
        Map<String,Object> result =new HashMap<>();
        result.put("MetaData",connection.getMetaData());
        result.put("ClientInfo",connection.getClientInfo());
        return result;
    }

}
