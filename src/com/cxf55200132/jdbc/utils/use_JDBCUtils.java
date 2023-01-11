package com.cxf55200132.jdbc.utils;

import com.alibaba.druid.proxy.jdbc.JdbcParameter;
import org.testng.annotations.Test;

import java.sql.*;


public class use_JDBCUtils {
    @Test
    public void testDml() throws SQLException {
        Connection con = null;
        String sql = "UPDATE templ set phoneno = ? where empno = ? ";

        PreparedStatement ps = null;


        try{
            con = JDBCUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setNull(1, Types.VARCHAR);
            ps.setString(2,"552020");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DruidUtils.close(null,ps,con);
        }
    }
}
