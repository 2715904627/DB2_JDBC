package com.cxf55200132.jdbc.myjdbc;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionTest {
    @Test
    public static void test01() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        //注册驱动
//        Driver driver = new com.mysql.cj.jdbc.Driver();
        Driver driver = new com.mysql.cj.jdbc.Driver();
        //创建连接1
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

    @Test
    public void test02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
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

    @Test
    public void test03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "Cxx197559";
        DriverManager.registerDriver(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);



    }



    @Test
    public void DB2test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class clazz = Class.forName("com.ibm.db2.jcc.DB2Driver");
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:db2://192.168.31.130:50000/sample";
        String user = "student";
        String password = "Cxx197559";
        DriverManager.registerDriver(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);
        String sql = "DELETE FROM ALBEXP WHERE ARTNO = 200";
        Statement statement = con.createStatement();
        int rows  = statement.executeUpdate(sql);
        System.out.println(rows>0?"Greetings":"Sorry")
        ;

        //关闭连接
        statement.close();
        con.close();


    }

    @Test
    public void test04() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password ="Cxx197559";
//        DriverManager.registerDriver(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);



    }

    @Test
    public void test05() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/DB2/properties"));
        String user = properties.getProperty("user");
        String passwd = properties.getProperty("passwd");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, passwd);
        System.out.println(con);

        con.close();

    }
}
