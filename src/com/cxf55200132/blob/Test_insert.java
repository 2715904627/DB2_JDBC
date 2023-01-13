package com.cxf55200132.blob;

import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.math.*;
public class Test_insert {

    public Test_insert(String EMPNO,String Photo_Format) throws Exception {
        Connection conn = this.createConnection();


        // Blob对象的插入的方法:
        try {


            // 创建插入语句.
            java.sql.PreparedStatement preparedStatement = conn
                    .prepareStatement("insert into student.emp_photo values(?,?,?)");


            //创建文件对象:

            File file=new File("C:/Users/Tlaloc/IdeaProjects/E-JDBC/src/com/cxf55200132/blob/img/0001.jpg");


            // 创建流对象:
            java.io.BufferedInputStream imageInput = new java.io.BufferedInputStream(
                    new java.io.FileInputStream(file));


            //参数赋值:
            preparedStatement.setString(1,EMPNO);
            preparedStatement.setString(2,Photo_Format);
            preparedStatement.setBinaryStream(3, imageInput,(int) file.length());


            //执行语句
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Congratulations");


            //------------------------------------------------------------------
            //Blob的读取工作:


//   java.sql.Statement st=conn.createStatement();


//   java.sql.ResultSet rs=st.executeQuery("select image from weihuachao.blobTest");


//   while(rs.next())
//   {
            //读取Blob对象
//    Blob blob= (Blob) rs.getBlob(1);


            //Blob对象转化为InputStream流
//    java.io.InputStream inputStream =blob.getBinaryStream();


            //要写入的文件
//    File fileOutput = new File("c:/backa.jpg");


            //文件的写入流的定义
//    FileOutputStream fo = new FileOutputStream(fileOutput);


//    int c;
            //读取流并写入到文件中
//    while ((c = inputStream.read()) != -1)
//    fo.write(c);


            //流的关闭:
//    fo.close();

//   }

        } catch (SQLException e) {


            // TODO 自动生成 catch 块
            e.printStackTrace();
        }catch(java.io.FileNotFoundException ex)

        {

            ex.printStackTrace();
        }catch(java.io.IOException ex)
        {

            ex.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
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



        } catch (SQLException ex1) {
            ex1.printStackTrace();


        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

}//结束.
