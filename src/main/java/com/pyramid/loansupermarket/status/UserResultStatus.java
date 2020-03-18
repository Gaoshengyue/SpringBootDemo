package com.pyramid.loansupermarket.status;

import com.pyramid.loansupermarket.model.User;

public class UserResultStatus {

    private Integer statusCode;
    private String message;
    private User user;

    public void setUser(User user) {
        this.user = user;

    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

}
