package com.cxf55200132.jdbc.ResultSet;

import com.mysql.cj.protocol.x.Notice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class RS_DB2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/DB2/properties"));

        String user = properties.getProperty("user");
        String passwd = properties.getProperty("passwd");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, passwd);
        System.out.println(con);
        Statement statement = con.createStatement();
        String sql = "SELECT * FROM act";
        java.sql.ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            int actno = rs.getInt(1);
            String actkwd = rs.getString(2);
            String actdesc = rs.getString(3);
            System.out.println(actno + "\t" + actkwd + "\t" + actdesc);
        }
        rs.close();
        statement.close();
        con.close();
    }
}
