package com.cxf55200132.blob;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.math.*;
public class Test_insert {

    public static void main(String[] args) throws Exception {

        Test_insert test = new Test_insert();
        Connection conn = test.createConnection();


        // Blob对象的插入的方法:
        try {


            // 创建插入语句.
            java.sql.PreparedStatement preparedStatement = conn
                    .prepareStatement("insert into administrator.emp_photo values('000130','jpeg',?)");


            //创建文件对象:

            File file=new File("c:/a.jpg");


            // 创建流对象:
            java.io.BufferedInputStream imageInput = new java.io.BufferedInputStream(
                    new java.io.FileInputStream(file));


            //参数赋值:
            preparedStatement.setBinaryStream(1, imageInput,(int) file.length());


            //执行语句
            preparedStatement.executeUpdate();



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


            Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");

            conn = java.sql.DriverManager.getConnection("jdbc:db2:sample",
                    "db2admin", "db2admin");


        } catch (SQLException ex1) {
            ex1.printStackTrace();


        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

}//结束.
