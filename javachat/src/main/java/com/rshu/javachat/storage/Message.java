package com.rshu.javachat.storage;

public class Message {
    private Integer messageId;
    private Integer userId;
    private Integer chatId;
    private String content;

    public Message(User user, Chat chat, String content) {
        this.content = content;
        chatId = chat.getChatId();
        userId = user.getUserId();
        messageId = DBInterlayer.getMessageId(userId, chatId, content);
    }

    public Message(Integer messageId, Integer userId, Integer chatId, String content) {
        this.messageId = messageId;
        this.userId = userId;
        this.chatId = chatId;
        this.content = content;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public String getContent() {
        return content;
    }

    public User getSender() {
        return new User(userId);
    }

    public Chat getChat() {
        return new Chat(chatId);
    }
}
