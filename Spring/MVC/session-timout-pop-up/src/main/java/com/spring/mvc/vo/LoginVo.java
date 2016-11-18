package com.spring.mvc.vo;

import java.io.Serializable;

public class LoginVo implements Serializable{

    private static final long serialVersionUID = -1L;

    private String userName;
    private String password;

    public LoginVo(){
        super();
    }

    public LoginVo(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }
}