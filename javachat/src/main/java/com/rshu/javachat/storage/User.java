package com.rshu.javachat.storage;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String login;

    public User(Integer userId) {
        this.userId = userId;
        this.login = DBInterlayer.getUserLogin(userId);
    }

    public User(String login) {
        this.userId = DBInterlayer.getUserId(login);
        this.login = login;
    }

    public User(Integer userId, String login) {
        this.userId = userId;
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public List<Chat> getChats() {
        return DBInterlayer.getUserChats(userId);
    }

    public List<Message> getMessages() {
        return DBInterlayer.getUserMessages(userId);
    }
}
