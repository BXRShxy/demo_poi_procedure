package com.njust.milestone.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 连接数据库
 *
 * @author 修身 since 2018/10/23
 **/

public class DBUtil {
    private static String username;
    private static String pwd;
    private static String url;

    static {

        try {
            ClassLoader classLoader = DBUtil.class.getClassLoader();

            InputStream is = classLoader.getResourceAsStream("application.yml");

            // System.out.println(is.available());

            Properties props = new Properties();
            props.load(is);

            url = props.getProperty("url");
            username = props.getProperty("username");
            pwd = props.getProperty("password");
            String driver = props.getProperty("driver-class-name");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, pwd);
        if (conn == null) {
            System.out.print("Failed to connect database... --> ");
        } else {
            System.out.print("database connected successful... --> ");
        }
        return conn;

    }

    public static void release(ResultSet rs, PreparedStatement sta, Connection conn) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" --> Resource release successful...");
    }

    public static void release(PreparedStatement sta, Connection conn) {
        if (sta != null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" --> Resource release successful...");
    }

}
