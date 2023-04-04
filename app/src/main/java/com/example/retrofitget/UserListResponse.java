package com.example.retrofitget;

import java.util.HashMap;
import java.util.Map;

public class UserListResponse {
    String id;
    String name;
    String email;
    String password;
    String com_code;
    String status;
    String forgot;
    Map<String, Object> additionalproperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCom_code() {
        return com_code;
    }

    public void setCom_code(String com_code) {
        this.com_code = com_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getForgot() {
        return forgot;
    }

    public void setForgot(String forgot) {
        this.forgot = forgot;
    }

    public Map<String, Object> getAdditionalproperties() {
        return additionalproperties;
    }

    public void setAdditionalproperties(Map<String, Object> additionalproperties) {
        this.additionalproperties = additionalproperties;
    }
}
