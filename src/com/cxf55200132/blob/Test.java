package com.cxf55200132.blob;

import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.math.*;
public class Test {

    public Test(String EMPNO) throws Exception {

        int k=1;
        Connection conn = this.createConnection();
        try {
            JOptionPane.showMessageDialog(null,"Congratulations");
            String sql = "select picture from student.emp_photo where empno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,EMPNO);

            java.sql.ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                //读取Blob对象
                Blob blob= (Blob) rs.getBlob(1);
                //Blob对象转化为InputStream流
                java.io.InputStream inputStream =blob.getBinaryStream();
                //要写入的文件
                File fileOutput = new File("C:/Users/Tlaloc/IdeaProjects/E-JDBC/src/com/cxf55200132/blob/img/0001.jpg");
                //文件的写入流的定义
                FileOutputStream fo = new FileOutputStream(fileOutput);
                int c;
                //读取流并写入到文件中
                while ((c = inputStream.read()) != -1) {

                    fo.write(c);
                }
                //流的关闭:
                fo.close();

            }
        }
        catch (SQLException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();}
        catch(java.io.FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch(java.io.IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try {     conn.close();
            } catch (SQLException e) {
                // TODO 自动生成 catch 块
                e.printStackTrace();
            }
        }
    }

    /**
     * 定义数据库连接的方法
     *
     * @return
     */
    private Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName ("com.ibm.db2.jcc.DB2Driver");
            conn = DriverManager.getConnection("jdbc:db2://192.168.31.130:50000/sample","student","Cxx197559");
        }
        catch (SQLException ex1) {
            ex1.printStackTrace();  }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();  }
        return conn;
    }
}



