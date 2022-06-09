package com.rshu.javachat.storage;

import java.util.ArrayList;
import java.util.List;

public class Chat extends DBInterlayer {
    private Integer chatId;
    private String name;

    public Chat(Integer chatId) {
        this.chatId = chatId;
        this.name = DBInterlayer.getChatName(chatId);
    }

    public Chat(Integer chatId, String name) {
        this.chatId = chatId;
        this.name = name;
    }

    public Integer getChatId() {
        return chatId;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return DBInterlayer.geChatUsers(chatId);
    }

    public List<Message> getMessages() {
        return DBInterlayer.getChatMessages(chatId);
    }
}
