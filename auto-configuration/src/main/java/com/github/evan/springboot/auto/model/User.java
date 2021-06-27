package com.github.evan.springboot.auto.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String idCardNo;

    private String name;

    private Integer age;

}
