package org.example;

import results.FindR6CommandResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private Statement stmt;
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

    public void addUser(String name, long id) {
        String value = findR6CommandResult.getValue(name);
        String[] values = value.split("\n");
        float win = Float.parseFloat(values[1].substring(0, values[1].length() - 1));
        float kd = Float.parseFloat(values[0]);
        int matchPlayed = Integer.parseInt(values[2]);
        try {
            stmt.executeUpdate("INSERT INTO rainbow (ID, NICKNAME, KD, WIN, MATCH_PLAYED) VALUES" +
                    "('" + id + "','" + name + "','" + kd + "','" +
                    win + "','" + "','" + matchPlayed + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public void getData(long id) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM rainbow WHERE ID = " + Long.toString(id));
            while (rs.next()) {
                String str = rs.getString("contact_id") + ":" + rs.getString(2);
                System.out.println("Contact:" + str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

