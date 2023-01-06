package com.cxf55200132.jdbc.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Druid {
    @Test
    public void testDruid() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection con = dataSource.getConnection();
        System.out.println("successfully connect!!!");
        con.close();


    }
}
