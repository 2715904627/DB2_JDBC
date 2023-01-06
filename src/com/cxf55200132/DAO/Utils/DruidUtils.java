package com.cxf55200132.DAO.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {

    private static DataSource ds;

    static{
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close(ResultSet rs, Statement statement,Connection con) throws SQLException {
        if(rs!=null){
            rs.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(con!=null){
            con.close();
        }

    }
}
