package com.pys.shiro.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Data
public class LoginParam implements Serializable {

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "password不能为空")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
