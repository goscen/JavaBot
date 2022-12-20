package org.example;

import results.FindR6CommandResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Database {
    public Statement stmt;
    FindR6CommandResult findR6CommandResult = new FindR6CommandResult();

    public void connectDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/usersdb";
            String login = "postgres";
            String password = "";
            Connection con = DriverManager.getConnection(url, login, password);
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(String[] name) {
        String value = findR6CommandResult.getValue(name);
        String[] values = value.split("\n");
        float win = Float.parseFloat(values[2].substring(5, values[2].length() - 1));
        float kd = Float.parseFloat(values[1].substring(4, values[1].length()));
        int matchPlayed = Integer.parseInt(values[3].substring(14, values[3].length()));
        try {
            ResultSet rs = stmt.executeQuery("SELECT EXISTS (SELECT * FROM rainbow where nickname = '"
                    + name[1] + "')");
            rs.next();
            if (Objects.equals(rs.getString(1), "f")) {
                stmt.executeUpdate("INSERT INTO rainbow (ID,NICKNAME, KD, WIN, MATCH_PLAYED) VALUES" +
                        "('" + name[0] + "','" + name[1] + "','" + kd + "','" +
                        win + "','" + matchPlayed + "')");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getData(String[] name) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM rainbow WHERE NICKNAME = " + name[1]);
            while (rs.next()) {
                String str = rs.getString("contact_id") + ":" + rs.getString(2);
                System.out.println("Contact:" + str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sdq";
    }
}

