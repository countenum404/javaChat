package com.rshu.javachat.storage;


import java.sql.*;

public class PDBInterlayer {
    private String url = "jdbc:postgresql://127.0.0.1:5433/";
    private String user = "postgres";
    private String password = "postgres";
    private Connection con = null;
    public PDBInterlayer() {
        reconnect();
    }

    public Boolean reconnect() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("PDBInterlayer: postgres driver not found");
        } catch (SQLException e) {
            System.out.println("PDBInterlayer: db not connected");
        }
        return con != null;
    }

    public int getUserId(String login) {
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT user_id " +
                    "FROM javachat.users " +
                    "WHERE login = '" + login + "';"
            );
            if (!result.next()) {
                statement.execute(
                    "INSERT INTO javachat.users(login)" +
                            "VALUES ('" + login + "');"
                );
                result = statement.executeQuery(
                        "SELECT user_id " +
                        "FROM javachat.users " +
                        "WHERE login = '" + login + "';"
                );
                result.next();
            }
            return result.getInt(1);

        } catch (SQLException e) {
            System.out.println("PDBInterlayer: query failed");
        }
        return -1;
    }

}
