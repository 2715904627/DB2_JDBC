package com.cxf55200132.jdbc.utils;

import org.testng.annotations.Test;

import java.sql.*;

public class use_DruidUtils {

    @Test
    public void testselect() throws SQLException {
        Connection con = null;
        String sql = "SELECT id,name,email,birth FROM customers WHERE id >= ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
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
                System.out.println(id + "\t" + name + "\t" + email + "\t" + birth);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DruidUtils.close(rs,ps,con);
        }
    }
}
