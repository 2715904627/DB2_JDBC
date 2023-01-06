package com.cxf55200132.jdbc.ResultSet;

import com.mysql.cj.protocol.x.Notice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ResultSet {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql/properties"));

        String user = properties.getProperty("user");
        String passwd = properties.getProperty("passwd");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, passwd);
        System.out.println(con);
        Statement statement = con.createStatement();
        String sql = "SELECT id,name,email,birth FROM customers";
        java.sql.ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            Date birth = rs.getDate(4);
            System.out.println(id + "\t" + name + "\t" + email + "\t" + birth);
        }
        rs.close();
        statement.close();
        con.close();
    }
}
