package com.cxf55200132.DAO.Test;

import com.cxf55200132.DAO.Dao.ACTDAO;
import com.cxf55200132.DAO.Dao.CustomerDAO;
import com.cxf55200132.DAO.Dao.TEMPLDAO;
import com.cxf55200132.DAO.Domain.ACT;
import com.cxf55200132.DAO.Domain.TEMPL;
import com.cxf55200132.jdbc.utils.Customer;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class TestDAO {
    @Test
    public void TestCustomerDAO() throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> list = customerDAO.QueryMultiply("SELECT * FROM customers WHERE id >= ?", Customer.class, 10);
        for(Customer customer : list){
            System.out.println(customer);
        }
//        System.out.println(customerDAO.QuerySingle("SELECT * FROM customers WHERE id = ? ",Customer.class , 1 ));

//        Object name = customerDAO.QueryScalar("SELECT name FROM customers WHERE id = ?", 1);
//        System.out.println(name);
//        System.out.println(customerDAO.Update("INSERT INTO customers (id,name,email,birth) VALUES(100,'HOLO','1515154515@AAD.COM','2022-01-14')"));
    }

    @Test
    public void TestACTDAO() throws SQLException {
        TEMPLDAO templdao = new TEMPLDAO();
        List<TEMPL> list = templdao.QueryMultiply("SELECT * FROM employee ", TEMPL.class);
        for(TEMPL templ : list){
            System.out.println(templ);
        }
//        System.out.println(customerDAO.QuerySingle("SELECT * FROM customers WHERE id = ? ",Customer.class , 1 ));

//        Object name = actdao.QueryScalar("SELECT ACTNO FROM act");
//        System.out.println(name);
//        int rows = actdao.Update("INSERT INTO act (ACTNO,ACTKWD,ACTDESC) VALUES(111,'DOC','DOCUMENT')");
//        System.out.println(rows);
    }
}
