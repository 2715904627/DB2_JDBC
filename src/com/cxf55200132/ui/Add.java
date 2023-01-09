package com.cxf55200132.ui;

import com.cxf55200132.DAO.Dao.ACTDAO;
import com.cxf55200132.DAO.Dao.TEMPLDAO;
import com.cxf55200132.DAO.Domain.ACT;
import com.cxf55200132.DAO.Domain.TEMPL;
import com.cxf55200132.view.MainForm;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;


    public static void main(String[] args) throws SQLException {
        Add add = new Add();
    }




    public Add() throws SQLException {
        InitView();

        tabData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selrow = tabData.getSelectedRow();
                if (selrow > -1) {
                    setTEMPLvalues(selrow);
                }
            }
        });
        btn_single.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EMPNO = textField1.getText();
                String FIRSTNME = textField2.getText();
                String MIDINIT = textField3.getText();
                String LASTNAME = textField4.getText();
                String WORKDEPT = textField5.getText();
                String PHONENO = textField6.getText();
                String HIREDATE = textField7.getText();
                String JOB = textField8.getText();
                String EDLEVEL = textField9.getText();
                String SEX = textField10.getText();
                String BIRTHDATE = textField11.getText();
                String SALARY = textField12.getText();
                String BONUS = textField13.getText();
                String COMM = textField14.getText();

                TEMPL templ = new TEMPL(EMPNO,FIRSTNME,MIDINIT,LASTNAME,WORKDEPT,PHONENO,  java.sql.Date.valueOf(HIREDATE),JOB,Integer.valueOf(EDLEVEL),SEX,java.sql.Date.valueOf(BIRTHDATE),SALARY,BONUS,COMM);

//                ACT act = new ACT(Integer.valueOf(actno),actkwd,actdesc);
//                System.out.println(act);
//                ACTDAO actDAO = new ACTDAO();
//        System.out.println(act.getACTNO());
                try {
                    int rows = templdao.Update("INSERT INTO employee (EMPNO,FIRSTNME,MIDINIT,LASTNAME,WORKDEPT,PHONENO, HIREDATE,JOB,EDLEVEL,SEX,BIRTHDATE,SALARY,BONUS,COMM) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",templ.getEMPNO(),templ.getFIRSTNME(),templ.getMIDINIT(), templ.getLASTNAME(),templ.getWORKDEPT(),templ.getPHONENO(),templ.getHIREDATE(),templ.getJOB(),templ.getEDLEVEL(),templ.getSEX(),templ.getBIRTHDATE(),templ.getSALARY(),templ.getBONUS(),templ.getCOMM());
                    if(rows>0){
                        JOptionPane.showMessageDialog(null,"Greetings");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Sorry");

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
//        int rows = actDAO.Update("INSERT INTO act (ACTNO,ACTKWD,ACTDESC) VALUES(121,'DOC','DOCUMENT')");


            }
        });
        btn_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                try {
//                    List<TEMPL> list = templdao.QueryMultiply("SELECT * FROM employee", TEMPL.class);
//
//                    Object[][] data = new Object[list.size()][14];
//                    for (int i = 0; i < data.length ; i++) {
//                        data[i][0] = list.get(i).getEMPNO();
//                        data[i][1] = list.get(i).getFIRSTNME();
//                        data[i][2] = list.get(i).getMIDINIT();
//                        data[i][3] = list.get(i).getLASTNAME();
//                        data[i][4] = list.get(i).getWORKDEPT();
//                        data[i][5] = list.get(i).getPHONENO();
//                        data[i][6] = list.get(i).getHIREDATE();
//                        data[i][7] = list.get(i).getJOB();
//                        data[i][8] = list.get(i).getEDLEVEL();
//                        data[i][9] = list.get(i).getSEX();
//                        data[i][10] = list.get(i).getBIRTHDATE();
//                        data[i][11] = list.get(i).getSALARY();
//                        data[i][12] = list.get(i).getBONUS();
//                        data[i][13] = list.get(i).getCOMM();
//
//                        tabData.setModel(new DefaultTableModel(data, columnNames));
//
//                    }
//
//
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
                try {
                    new MainTab();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btn_muldel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String EMPNO = textField1.getText();
                String FIRSTNME = textField2.getText();
                String MIDINIT = textField3.getText();
                String LASTNAME = textField4.getText();
                String WORKDEPT = textField5.getText();
                String PHONENO = textField6.getText();
                String HIREDATE = textField7.getText();
                String JOB = textField8.getText();
                String EDLEVEL = textField9.getText();
                String SEX = textField10.getText();
                String BIRTHDATE = textField11.getText();
                String SALARY = textField12.getText();
                String BONUS = textField13.getText();
                String COMM = textField14.getText();
                TEMPL templ = new TEMPL(EMPNO,FIRSTNME,MIDINIT,LASTNAME,WORKDEPT,PHONENO,  java.sql.Date.valueOf(HIREDATE),JOB,Integer.valueOf(EDLEVEL),SEX,java.sql.Date.valueOf(BIRTHDATE),SALARY,BONUS,COMM);
//                System.out.println(act);
//                ACTDAO actDAO = new ACTDAO();
//               System.out.println(act.getACTNO());
                try {
                    int rows = templdao.Update("delete from employee where empno = ?",templ.getEMPNO());
                    if(rows>0){
                        JOptionPane.showMessageDialog(null,"Greetings");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Sorry");

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
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

    private void setTEMPLvalues(int selrow) {
        if (tabData.getValueAt(selrow, 0) != null) {
            textField1.setText(tabData.getValueAt(selrow,0).toString());

        }
        if (tabData.getValueAt(selrow, 1) != null) {
            textField2.setText(tabData.getValueAt(selrow,1).toString());

        }
        if (tabData.getValueAt(selrow, 2) != null) {
            textField3.setText(tabData.getValueAt(selrow,2).toString());

        }
        if (tabData.getValueAt(selrow, 3) != null) {
            textField4.setText(tabData.getValueAt(selrow,3).toString());

        }
        if (tabData.getValueAt(selrow, 4) != null) {
            textField5.setText(tabData.getValueAt(selrow,4).toString());

        }
        if (tabData.getValueAt(selrow, 5) != null) {
            textField6.setText(tabData.getValueAt(selrow,5).toString());

        }
        if (tabData.getValueAt(selrow, 6) != null) {
            textField7.setText(tabData.getValueAt(selrow,6).toString());

        }
        if (tabData.getValueAt(selrow, 7) != null) {
            textField8.setText(tabData.getValueAt(selrow,7).toString());

        }
        if (tabData.getValueAt(selrow, 8) != null) {
            textField9.setText(tabData.getValueAt(selrow,8).toString());

        }
        if (tabData.getValueAt(selrow, 9) != null) {
            textField10.setText(tabData.getValueAt(selrow,9).toString());

        }
        if (tabData.getValueAt(selrow, 10) != null) {
            textField11.setText(tabData.getValueAt(selrow,10).toString());

        }
        if (tabData.getValueAt(selrow, 11) != null) {
            textField12.setText(tabData.getValueAt(selrow,11).toString());

        }
        if (tabData.getValueAt(selrow, 12) != null) {
            textField13.setText(tabData.getValueAt(selrow,12).toString());

        }

        if (tabData.getValueAt(selrow, 13) != null) {
            textField14.setText(tabData.getValueAt(selrow,13).toString());

        }
//        if (tabData.getValueAt(selrow, 0) != null) {
//
//            System.out.print(tabData.getValueAt(selrow,0).toString());
//            System.out.print(" ");
//        }
//        if (tabData.getValueAt(selrow, 1) != null) {
//            System.out.print(tabData.getValueAt(selrow,1).toString());
//            System.out.print(" ");
//
//        }
//        if (tabData.getValueAt(selrow, 2) != null) {
//            System.out.print(tabData.getValueAt(selrow,2).toString());
//            System.out.print(" ");
//
//        }
    }
}

