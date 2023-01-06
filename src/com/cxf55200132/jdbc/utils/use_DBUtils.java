package com.cxf55200132.jdbc.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class use_DBUtils {
    @Test
    public void testbatchQuery() throws SQLException {
        Connection con = DruidUtils.getConnection();
        String sql = "SELECT * FROM customers WHERE id >= ?";
        QueryRunner queryRunner = new QueryRunner();
        List<Customer> list = queryRunner.query(con, sql, new BeanListHandler<>(Customer.class), 15);
        for(Customer customer : list){

            System.out.println(customer);
        }
        DruidUtils.close(null,null,con);
    }

@Test
    public void testSingleQuery() throws SQLException {
        Connection con = DruidUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM customers WHERE id = ?";
        Customer query = queryRunner.query(con, sql, new BeanHandler<>(Customer.class), 1);
        System.out.println(query);
        DruidUtils.close(null,null,con);

    }


    @Test
    public void testDML() throws SQLException {
        Connection con = DruidUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "UPDATE customers SET name =? WHERE id = ?";
        int rows = queryRunner.update(con,sql,"Alexzander",20);
        System.out.println(rows>0?"Greetings":"Sorry");
        DruidUtils.close(null,null,con);

    }
}

