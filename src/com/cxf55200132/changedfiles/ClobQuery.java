package com.cxf55200132.changedfiles;

import com.cxf55200132.jdbc.utils.JDBCUtils;

import javax.swing.*;
import java.sql.*;

public class ClobQuery {
    private String resume = null;
    private String empnum = "000130";
    private int startper, startper1, startdpt = 0;
    private PreparedStatement stmt1 = null;
    private PreparedStatement stmt2 = null;
    private PreparedStatement stmt3 = null;
    private String sql1 = null;
    private String sql2 = null;
    private String sql3 = null;
    private String empno, resumefmt = null;
    private Clob resumelob = null;
    private ResultSet rs1, rs2, rs3 = null;
    private String resumeout = null;


    public ClobQuery() throws SQLException {
        sql1 = "SELECT POSSTR(RESUME,'Personal') "
                + "FROM EMP_RESUME "
                + "WHERE EMPNO = ? AND RESUME_FORMAT = 'ascii'";
        Connection con = JDBCUtils.getConnection();
        stmt1 = con.prepareStatement(sql1);
        stmt1.setString(1, empnum);
        rs1 = stmt1.executeQuery();
        while (rs1.next()) {
            startper = rs1.getInt(1);
        } // end while
        sql2 = "SELECT POSSTR(RESUME,'Department') "
                + "FROM EMP_RESUME "
                + "WHERE EMPNO = ? AND RESUME_FORMAT = 'ascii'";
        stmt2 = con.prepareStatement(sql2);
        stmt2.setString(1, empnum);
        rs2 = stmt2.executeQuery();
        while (rs2.next()) {
            startdpt = rs2.getInt(1);
        } // end while
        startper1 = startper - 1;
        sql3 = "SELECT EMPNO, RESUME_FORMAT,"
                + "SUBSTR(RESUME,1,?)|| SUBSTR(RESUME,?) AS RESUME "
                + "FROM EMP_RESUME "
                + "WHERE EMPNO = ? AND RESUME_FORMAT = 'ascii'";
        stmt3 = con.prepareStatement(sql3);
        stmt3.setInt(1, startper1);
        stmt3.setInt(2, startdpt);
        stmt3.setString(3, empnum);
        rs3 = stmt3.executeQuery();
        while (rs3.next()) {
            empno = rs3.getString(1);
            resumefmt = rs3.getString(2);
            resumelob = rs3.getClob(3);
            long len = resumelob.length();
            int len1 = (int)len;
            resumeout = resumelob.getSubString(1, len1);
        }
        System.out.println(empnum);
        System.out.println(empno);
        System.out.println(resumefmt);
        System.out.println(resumeout);
    }

    public static void main(String[] args) throws SQLException {
        ClobQuery clobQuery = new ClobQuery();
    }
}