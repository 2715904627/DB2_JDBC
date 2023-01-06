package com.cxf55200132.jdbc.utils;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class use_JDBCUtils {
    @Test
    public void testDml() throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "update customers set name = ? where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,"Alex");
        ps.setInt(2,20);
        ps.executeUpdate();

        JDBCUtils.close(null,ps,con);

    }
}
