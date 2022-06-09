package com.rshu.javachat.storage;

public class Query {
    public static String getUserLogin(Integer userId) {
        return String.format(
                "SELECT login\n" +
                "FROM javachat.\"Users\"\n" +
                "WHERE \"userId\" = %d;",
                userId
        );
    }
    public static String getUserId(String login) {
        return String.format(
                "SELECT \"userId\"\n" +
                "FROM javachat.\"Users\"\n" +
                "WHERE login = '%s';",
                login
        );
    }
    public static String addUser(String login) {
        return String.format(
                "INSERT\n" +
                "INTO javachat.\"Users\"(login)\n" +
                "VALUES ('%s')",
                login
        );
    }
    public static String getUserChats(Integer userId) {
        return String.format(
                "SELECT c.\"chatId\", name\n" +
                "FROM javachat.\"Chats\" c, javachat.\"UserChats\" uc\n" +
                "WHERE uc.\"userId\"=%d\n" +
                "  AND c.\"chatId\"=uc.\"chatId\";",
                userId
        );
    }
    public static String getUserMessages(Integer userId) {
        return String.format(
                "SELECT \"messageId\", \"chatId\", content \n" +
                "FROM javachat.\"Messages\"\n" +
                "WHERE \"userId\"=%d;",
                userId
        );
    }

    public static String getChatName(Integer chatId) {
        return String.format(
                "SELECT name\n" +
                "FROM javachat.\"Chats\"\n" +
                "WHERE \"chatId\"=%d;",
                chatId
        );
    }
    public static String getChatId(String name) {
        return String.format(
                "SELECT \"chatId\"\n" +
                "FROM javachat.\"Chats\"\n" +
                "WHERE name = '%s';",
                name
        );
    }
    public static String addChat(String name) {
        return String.format(
                "INSERT\n" +
                "INTO javachat.\"Chats\"(name)\n" +
                "VALUES ('%s')",
                name
        );
    }
    public static String getChatUsers(Integer chatId) {
        return String.format(
                "SELECT u.\"userId\", login\n" +
                "FROM javachat.\"Users\" u, javachat.\"UserChats\" uc\n" +
                "WHERE uc.\"chatId\"=%d\n" +
                "  AND u.\"userId\"=uc.\"userId\";",
                chatId
        );
    }
    public static String getChatMessages(Integer chatId) {
        return String.format(
                "SELECT \"messageId\", \"userId\", content \n" +
                "FROM javachat.\"Messages\"\n" +
                "WHERE \"chatId\"=%d;",
                chatId
        );
    }
    public static String addMessageAndGetId(Integer userId, Integer chatId, String content) {
        return String.format(
                "INSERT INTO javachat.\"Messages\"(\"userId\", \"chatId\", content)\n" +
                "VALUES (%d, %d, '%s')\n" +
                "RETURNING \"messageId\";",
                userId, chatId, content
        );
    }
}
