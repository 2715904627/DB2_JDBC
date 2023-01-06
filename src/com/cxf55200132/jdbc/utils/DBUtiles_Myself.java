package com.cxf55200132.jdbc.utils;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;

public class DBUtiles_Myself {

    @Test
    public void testselect() throws SQLException {
        Connection con = null;
        String sql = "SELECT id,name,email,birth FROM customers WHERE id >= ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Customer> list  = new ArrayList<>();

        try{
            con = DruidUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,15);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                Date birth = rs.getDate(4);
//                System.out.println(id + "\t" + name + "\t" + email + "\t" + birth);
                list.add(new Customer(id,name,email,birth));
            }
            System.out.println("Data From List is : "+list);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DruidUtils.close(rs,ps,con);
        }
    }

}
