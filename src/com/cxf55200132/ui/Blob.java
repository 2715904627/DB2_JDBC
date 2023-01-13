package com.cxf55200132.ui;

import com.cxf55200132.DAO.Dao.PHOTODAO;
import com.cxf55200132.DAO.Dao.TEMPLDAO;
import com.cxf55200132.DAO.Domain.Emp_Photo;
import com.cxf55200132.DAO.Domain.TEMPL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Blob {
    private JPanel JPMain;
    private JTable tabData;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton btn_query;
    private JButton btn_add;
    private JButton btn_refresh;
    private  PHOTODAO photodao = new PHOTODAO();
    String[] columnNames = {"EMPNO", "FIRSTNME", "MIDINIT", "LASTNAME", "WORKDEPT", "PHONENO", "HIREDATE", "JOB", "EDLEVEL", "SEX", "BIRTHDATE", "SALARY", "BONUS", "COMM"};


    public Blob() throws SQLException {
        InitView();
    }

    public static void main(String[] args) throws SQLException {
        Blob blob = new Blob();
    }


    private void InitView() throws SQLException {
        JFrame frame = new JFrame("DB2_cxf55200132");
        frame.setBounds(560, 45, 640, 450);
        frame.setContentPane(this.JPMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        InitTable();


    }


    private void InitTable() throws SQLException {
        List<Emp_Photo> list = photodao.QueryMultiply("SELECT * FROM emp_photo", Emp_Photo.class);

        Object[][] data = new Object[list.size()][3];

        for (int i = 0; i < data.length; i++) {
            data[i][0] = list.get(i).getEMPNO();
            data[i][1] = list.get(i).getPHOTO_FORMAT();
            data[i][2] = list.get(i).getPICTURE().toString();
        }
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
        tabData.setModel(dtm);
    }

    private void setTEMPLvalues(int selrow) {
        if (tabData.getValueAt(selrow, 0) != null) {
            textField1.setText(tabData.getValueAt(selrow, 0).toString());

        }
        if (tabData.getValueAt(selrow, 1) != null) {
            textField2.setText(tabData.getValueAt(selrow, 1).toString());

        }
        if (tabData.getValueAt(selrow, 2) != null) {
            textField3.setText(tabData.getValueAt(selrow, 2).toString());

        }

    }


}
