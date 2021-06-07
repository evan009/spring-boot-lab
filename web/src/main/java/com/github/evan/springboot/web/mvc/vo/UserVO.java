package com.github.evan.springboot.web.mvc.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc: 用户VO对象
 * @author: evan
 * @date: 2021-06-07 16:09
 */
@Data
@NoArgsConstructor
public class UserVO {

    private String userName;

    private int age;

    private String desc;

}
