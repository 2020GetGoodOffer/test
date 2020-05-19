package com.sjh.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Data
public class Account {
    
    @NotEmpty(message = "用户名不能为空")
    private String name;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, max = 12, message = "密码是6~12位的")
    private String password;

}
