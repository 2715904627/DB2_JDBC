package com.cxf55200132.ui;

import com.cxf55200132.DAO.Dao.ACTDAO;
import com.cxf55200132.DAO.Domain.ACT;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class Add {


    private ACTDAO actdao = new ACTDAO();
    String[] columnNames = {"ACTNO","ACTKWD","ACTDESC"};

    private JTable tabData;
    private JButton btn_single;
    private JButton btn_muladd;
    private JButton btn_muldel;
    private JButton btn_query;
    private JPanel JPMain;



    public static void main(String[] args) throws SQLException {
        Add add = new Add();
    }



    public Add() throws SQLException {
        InitView();
    }
    private  void InitView() throws SQLException {
        JFrame frame = new JFrame("DB2_cxf55200132");
        frame.setBounds(560,45,640,450);
        frame.setContentPane(this.JPMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        InitTable();
    }


    private  void InitTable() throws SQLException {
        List<ACT> list = actdao.QueryMultiply("SELECT * FROM act WHERE ACTNO >= ?", ACT.class,20);

        Object[][] data = new Object[list.size()][3];
        for (int i = 0; i < data.length ; i++) {
            data[i][0] = list.get(i).getACTNO();
            data[i][1] = list.get(i).getACTKWD();
            data[i][2] = list.get(i).getACTDESC();

        }
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
        tabData.setModel(dtm);
    }
}

