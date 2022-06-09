package com.rshu.javachat.storage;


import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class DBInterlayer {
    private static Connection con;
    private static Statement s;

    public static void init() {
        try {
            con = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5433/postgres",
                "postgres",
                "postgres"
            );
            s = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUserLogin(Integer userId) {
        try {
            String getUserIdQuery = Query.getUserLogin(userId);
            ResultSet rs = s.executeQuery(getUserIdQuery);
            return rs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer getUserId(String login) {
        try {
            String getUserIdQuery = Query.getUserId(login);
            ResultSet rs = s.executeQuery(getUserIdQuery);
            if (!rs.next()) {
                s.execute(Query.addUser(login));
                rs = s.executeQuery(getUserIdQuery);
                rs.next();
            }
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Chat> getUserChats(Integer userId) {
        ArrayList<Chat> chats = new ArrayList<>();
        try {
            ResultSet rs = s.executeQuery(Query.getUserChats(userId));
            while (rs.next()) {
                chats.add(new Chat(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return chats;
    }

    public static List<Message> getUserMessages(Integer userId) {
        ArrayList<Message> messages = new ArrayList<>();
        try {
            ResultSet rs = s.executeQuery(Query.getUserMessages(userId));
            while (rs.next()) {
                messages.add(new Message(rs.getInt(1), userId,
                        rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    public static String getChatName(Integer chatId) {
        try {
            String getUserIdQuery = Query.getChatName(chatId);
            ResultSet rs = s.executeQuery(getUserIdQuery);
            return rs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer getChatId(String name) {
        try {
            String getChatIdQuery = Query.getChatId(name);
            ResultSet rs = s.executeQuery(getChatIdQuery);
            if (!rs.next()) {
                s.execute(Query.addChat(name));
                rs = s.executeQuery(getChatIdQuery);
                rs.next();
            }
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> geChatUsers(Integer chatId) {
        ArrayList<User> users = new ArrayList<>();
        try {
            ResultSet rs = s.executeQuery(Query.getChatUsers(chatId));
            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static List<Message> getChatMessages(Integer chatId) {
        ArrayList<Message> messages = new ArrayList<>();
        try {
            ResultSet rs = s.executeQuery(Query.getChatMessages(chatId));
            while (rs.next()) {
                messages.add(new Message(rs.getInt(1), rs.getInt(2),
                        chatId, rs.getString(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    public static Integer getMessageId(Integer userId, Integer chatId, String content) {
        try {
            ResultSet rs = s.executeQuery(Query.addMessageAndGetId(userId, chatId, content));
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
