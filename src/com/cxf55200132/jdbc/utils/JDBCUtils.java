package com.cxf55200132.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String user;
    private static String passwd;
    private static String url;
    private static String driver;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/DB2/properties"));
            user = properties.getProperty("user");
            passwd = properties.getProperty("passwd");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,user,passwd);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet set, Statement statement,Connection con) throws SQLException {
        try {
            if(set!=null){
                set.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(con!=null){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
