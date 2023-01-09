package com.cxf55200132.ui;

import com.cxf55200132.DAO.Dao.ACTDAO;
import com.cxf55200132.DAO.Dao.TEMPLDAO;
import com.cxf55200132.DAO.Domain.ACT;
import com.cxf55200132.DAO.Domain.TEMPL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class Add {


    private TEMPLDAO templdao = new TEMPLDAO();
    String[] columnNames = {"EMPNO","FIRSTNME","MIDINIT","LASTNAME","WORKDEPT","PHONENO","HIREDATE","JOB","EDLEVEL","SEX","BIRTHDATE","SALARY","BONUS","COMM"};


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
        List<TEMPL> list = templdao.QueryMultiply("SELECT * FROM employee", TEMPL.class);

        Object[][] data = new Object[list.size()][14];
        for (int i = 0; i < data.length ; i++) {
            data[i][0] = list.get(i).getEMPNO();
            data[i][1] = list.get(i).getFIRSTNME();
            data[i][2] = list.get(i).getMIDINIT();
            data[i][3] = list.get(i).getLASTNAME();
            data[i][4] = list.get(i).getWORKDEPT();
            data[i][5] = list.get(i).getPHONENO();
            data[i][6] = list.get(i).getHIREDATE();
            data[i][7] = list.get(i).getJOB();
            data[i][8] = list.get(i).getEDLEVEL();
            data[i][9] = list.get(i).getSEX();
            data[i][10] = list.get(i).getBIRTHDATE();
            data[i][11] = list.get(i).getSALARY();
            data[i][12] = list.get(i).getBONUS();
            data[i][13] = list.get(i).getCOMM();

        }
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
        tabData.setModel(dtm);
    }
}

