package com.cxf55200132.DAO.Dao;

import com.cxf55200132.jdbc.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class BasicDAO<T> {
    private QueryRunner qr =  new QueryRunner();
    //template dml operation
    public int Update(String sql,  Object... param) throws SQLException {

        Connection con = null;
        try {
            con = JDBCUtils.getConnection();
            int rows = qr.update(con,sql,param);

            return rows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null,null,con);
        }

    }

    public void MulUpdate(String sql, Object[][] param) throws SQLException {

        Connection con = null;
        try {
            con = JDBCUtils.getConnection();
            qr.batch(con,sql,param);

            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null,null,con);
        }

    }

    //MultiplyQuery
    public List<T> QueryMultiply(String sql, Class<T> clazz, Object... param) throws SQLException {
        Connection con = null;
        try {
            con = JDBCUtils.getConnection();
            System.out.println(con);
            return qr.query(con,sql,new BeanListHandler<T>(clazz),param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null,null,con);
        }


    }

    //SingleQuery
    public T QuerySingle(String sql, Class<T> clazz, Object... param) throws SQLException {
        Connection con = null;
        try {
            con = JDBCUtils.getConnection();
            return qr.query(con,sql,new BeanHandler<>(clazz),param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null,null,con);
        }

    }
    //ScalarQuery
    public Object QueryScalar(String sql, Object...param) throws SQLException {
        Connection con = null;
        try {
            con = JDBCUtils.getConnection();
            return qr.query(con,sql,new ScalarHandler(),param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null,null,con);
        }

    }
}
