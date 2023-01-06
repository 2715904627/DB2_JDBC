package com.cxf55200132.jdbc.myjdbc;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc01 {
    @Test
    public static void test01() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        //注册驱动
//        Driver driver = new com.mysql.cj.jdbc.Driver();
        Driver driver = new com.mysql.cj.jdbc.Driver();
        //创建连接
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
        Properties properties = new Properties();
        properties.setProperty("user" , "root" );
        properties.setProperty("password","Cxx197559");
        Connection con = driver.connect(url, properties);
        //执行sql语句
        String sql = "INSERT INTO customers \n" +
                "VALUES(21,'罗志祥','2715904451@163.com','1970-01-01',NULL);";
        Statement statement = con.createStatement();
        int rows  = statement.executeUpdate(sql);
        System.out.println(rows>0?"Greetings":"Sorry");

        //关闭连接
        statement.close();
        con.close();


    }
}
