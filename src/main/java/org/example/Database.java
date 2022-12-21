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

    public String addUser(String[] name) {
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
                return "Успех";
            }
            return "Аккаунт уже в БД";
        } catch (Exception e) {
            return "Что-то пошло не так";
        }
    }

    public String getData(String[] name) {
        String[] str = new String[2];
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM rainbow WHERE ID = '" + name[0] + "'");
            rs.next();
            String nickname = rs.getString(3);
            str[1] = nickname;
            float oldKd = rs.getFloat(1);
            float oldWin = rs.getFloat(2);
            int oldMatchPlayed = rs.getInt(4);
            String value = findR6CommandResult.getValue(str);
            String[] values = value.split("\n");
            float win = Float.parseFloat(values[2].substring(5, values[2].length() - 1));
            float kd = Float.parseFloat(values[1].substring(4, values[1].length()));
            int matchPlayed = Integer.parseInt(values[3].substring(14, values[3].length()));

            if (matchPlayed == oldMatchPlayed) {
                return value;
            }
            stmt.executeUpdate("UPDATE rainbow SET (kd, win, match_played) =(" + Float.toString(kd) + "," +
                    "" + Float.toString(win) + "," + Integer.toString(matchPlayed)
                    + ") where nickname ='" + nickname + "'");
            String newKd = Float.toString(kd - oldKd);
            String newWin = Float.toString(win - oldWin);
            String newMatch = Integer.toString(matchPlayed - oldMatchPlayed);
            return nickname + ": \n" + "KD: " + Float.toString(kd) + "(" + newKd + ")" + "\n"
                    + "WIN: " + Float.toString(win) + "(" + newWin + ")" + "\n"
                    + "Played Match: " + Integer.toString(matchPlayed) + "(" + newMatch + ")";

        } catch (Exception e) {
            return "Упс... Что-то пошло не так \nВозможно твоего аккауента нет в БД, Введи /link никнейм";
        }

    }

    public String deleteData(String[] name) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT EXISTS (SELECT * FROM rainbow where ID = '"
                    + name[0] + "')");
            rs.next();
            if (Objects.equals(rs.getString(1), "t")) {
                stmt.executeUpdate("delete from rainbow where id = '" + name[0] + "'");
            } else {
                return "Аккаунта нет в бд";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Аккаунт удален из БД";
    }
}


