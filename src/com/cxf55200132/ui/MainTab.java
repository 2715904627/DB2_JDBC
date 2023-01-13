package com.cxf55200132.ui;

import com.cxf55200132.DAO.Dao.TEMPLDAO;
import com.cxf55200132.DAO.Domain.TEMPL;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class MainTab {
    private TEMPLDAO templdao = new TEMPLDAO();
    String[] columnNames = {"EMPNO", "FIRSTNME", "MIDINIT", "LASTNAME", "WORKDEPT", "PHONENO", "HIREDATE", "JOB", "EDLEVEL", "SEX", "BIRTHDATE", "SALARY", "BONUS", "COMM"};


    private JTable tabData;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton btn_add;
    private JButton btn_delete;
    private JButton btn_update;
    private JButton btn_query;
    private JPanel JPMain;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JButton transButton;

    private String title1 = null;
    private String title2 = null;
    private String title3 = null;
    private String title4 = null;
    private String title5 = null;
    private String title6 = null;
    private String title7 = null;
    private String title8 = null;
    private String title9 = null;
    private String title10 = null;
    private String title11 = null;
    private String title12 = null;
    private String title13 = null;
    private String title14 = null;

//    private Object[][] param;

    private  int sqlnum = 0;
    private String[] SQL;

    private String MulInssql;

    private List<TEMPL> multempl = new ArrayList<>();


    public MainTab() throws SQLException {
        InitView();



        /*

        Need to Modify
        */

        btn_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    List<TEMPL> list = templdao.QueryMultiply("SELECT * FROM employee", TEMPL.class);

                    Object[][] data = new Object[list.size()][14];
                    for (int i = 0; i < data.length; i++) {
                        data[i][0] = list.get(i).getEMPNO();
                        data[i][2] = list.get(i).getMIDINIT();


                        String MIDINIT = data[i][2].toString();

                        if(MIDINIT.equals(" ") || MIDINIT == null){

                            templdao.Update("update employee set midinit = ? where empno = ?", "@",data[i][0].toString());

                        }

                    }
                    list = templdao.QueryMultiply("SELECT * FROM employee", TEMPL.class);

                    data = new Object[list.size()][14];
                    for (int i = 0; i < data.length; i++) {
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

                        String MIDINIT = data[i][2].toString();
                        if(MIDINIT.equals("@")){

                            templdao.Update("update employee set midinit = ? where empno = ?", "",data[i][0].toString());

                        }
                    }
                    tabData.setModel(new DefaultTableModel(data, columnNames));




                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }

        });


        tabData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int[] selrow = tabData.getSelectedRows();
                    int i = selrow.length;
                    //                param = new Object[i+1][14];
                    while (i > 0) {
                        i--;
                        try {
                            setTEMPLvalues(selrow[i]);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } finally {
                            for (int j = 0; j < selrow.length; j++) {
                                selrow[j] = 0;
                            }
                            //                        param = null;

                        }
                    }
                }
            }
        });
//        tabData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                int selrow = tabData.getSelectedRow();
//                if (selrow > -1) {
//                    setTEMPLvalues(selrow);
//                }
//            }
//        });
        btn_add.addActionListener(new ActionListener() {
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

                TEMPL templ = new TEMPL(EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, java.sql.Date.valueOf(HIREDATE), JOB, Integer.valueOf(EDLEVEL), SEX, java.sql.Date.valueOf(BIRTHDATE), SALARY, BONUS, COMM);

                try {
                    int rows = -1;
                    if(MIDINIT.equals("")  || MIDINIT ==  null){
                        rows = templdao.Update("INSERT INTO employee (EMPNO,FIRSTNME,MIDINIT,LASTNAME,WORKDEPT,PHONENO, HIREDATE,JOB,EDLEVEL,SEX,BIRTHDATE,SALARY,BONUS,COMM) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)", templ.getEMPNO(), templ.getFIRSTNME(), "@", templ.getLASTNAME(), templ.getWORKDEPT(), templ.getPHONENO(), templ.getHIREDATE(), templ.getJOB(), templ.getEDLEVEL(), templ.getSEX(), templ.getBIRTHDATE(), templ.getSALARY(), templ.getBONUS(), templ.getCOMM());

                    }
                    else{
                        rows = templdao.Update("INSERT INTO employee (EMPNO,FIRSTNME,MIDINIT,LASTNAME,WORKDEPT,PHONENO, HIREDATE,JOB,EDLEVEL,SEX,BIRTHDATE,SALARY,BONUS,COMM) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)", templ.getEMPNO(), templ.getFIRSTNME(), templ.getMIDINIT(), templ.getLASTNAME(), templ.getWORKDEPT(), templ.getPHONENO(), templ.getHIREDATE(), templ.getJOB(), templ.getEDLEVEL(), templ.getSEX(), templ.getBIRTHDATE(), templ.getSALARY(), templ.getBONUS(), templ.getCOMM());

                    }
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(null, "Congratulations");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry");

                    }
                } catch (SQLException ex) {

                    throw new RuntimeException(ex);
                }
//        int rows = actDAO.Update("INSERT INTO act (ACTNO,ACTKWD,ACTDESC) VALUES(121,'DOC','DOCUMENT')");

            }
        });
        btn_update.addActionListener(new ActionListener() {
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
                TEMPL templ = new TEMPL(EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, java.sql.Date.valueOf(HIREDATE), JOB, Integer.valueOf(EDLEVEL), SEX, java.sql.Date.valueOf(BIRTHDATE), SALARY, BONUS, COMM);
//                System.out.println(act);
//                ACTDAO actDAO = new ACTDAO();
//        System.out.println(act.getACTNO());
                try {
                    int rows = templdao.Update("update employee set edlevel = ? where empno = ?", templ.getEDLEVEL(), templ.getEMPNO());
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(null, "Congratulations");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry");

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete from act where actno = 111
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
                TEMPL templ = new TEMPL(EMPNO, FIRSTNME, MIDINIT, LASTNAME, WORKDEPT, PHONENO, java.sql.Date.valueOf(HIREDATE), JOB, Integer.valueOf(EDLEVEL), SEX, java.sql.Date.valueOf(BIRTHDATE), SALARY, BONUS, COMM);

                try {
                    int rows = templdao.Update("delete from employee where empno = ?", templ.getEMPNO());
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(null, "Congratulations");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry");

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        transButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object[][] param = new Object[multempl.size()][14];
                for (int i = 0; i < param.length; i++) {
                    param[i][0] = multempl.get(i).getEMPNO();
                    param[i][1] = multempl.get(i).getFIRSTNME();
                    param[i][2] = multempl.get(i).getMIDINIT();
                    param[i][3] = multempl.get(i).getLASTNAME();
                    param[i][4] = multempl.get(i).getWORKDEPT();
                    param[i][5] = multempl.get(i).getPHONENO();
                    param[i][6] = multempl.get(i).getHIREDATE();
                    param[i][7] = multempl.get(i).getJOB();
                    param[i][8] = multempl.get(i).getEDLEVEL();
                    param[i][9] = multempl.get(i).getSEX();
                    param[i][10] = multempl.get(i).getBIRTHDATE();
                    param[i][11] = multempl.get(i).getSALARY();
                    param[i][12] = multempl.get(i).getBONUS();
                    param[i][13] = multempl.get(i).getCOMM();

                }

                try {
                    templdao.MulUpdate(MulInssql, param);
//                    sqlnum = 0;
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }


    public static void main(String[] args) throws SQLException {
        MainTab mainTab = new MainTab();
    }

    private void InitView() throws SQLException {
        JFrame frame = new JFrame("DB2_cxf55200132");
        frame.setBounds(560, 45, 640, 450);
        frame.setContentPane(this.JPMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
//        update01();
        InitTable();


    }

    private void InitTable() throws SQLException {
        List<TEMPL> list = templdao.QueryMultiply("SELECT * FROM employee", TEMPL.class);

        Object[][] data = new Object[list.size()][14];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = list.get(i).getEMPNO();
            data[i][2] = list.get(i).getMIDINIT();
//            data[i][8] = list.get(i).getEDLEVEL();
            String MIDINIT = data[i][2].toString();
//            String EDLEVEL = data[i][8].toString();
//            if(EDLEVEL.equals("99")){
//                templdao.Update("update employee set edlevel = ? where empno = ?", 16,data[i][0].toString());
//
//            }
            if(MIDINIT.equals(" ") || MIDINIT == null){

                templdao.Update("update employee set midinit = ? where empno = ?", "@",data[i][0].toString());

            }
        }
        list = templdao.QueryMultiply("SELECT * FROM employee", TEMPL.class);
        data = new Object[list.size()][14];
        for (int i = 0; i < data.length; i++) {
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

            String MIDINIT = data[i][2].toString();
            if(MIDINIT.equals("@")){

                templdao.Update("update employee set midinit = ? where empno = ?", "",data[i][0].toString());

            }
        }
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
        tabData.setModel(dtm);
        }


    private void setTEMPLvalues(int selrow) throws SQLException {

        if (tabData.getValueAt(selrow, 0) != null) {
            textField1.setText(tabData.getValueAt(selrow, 0).toString());
            title1 = tabData.getValueAt(selrow, 0).toString();

        }
        if (tabData.getValueAt(selrow, 1) != null) {
            textField2.setText(tabData.getValueAt(selrow, 1).toString());
            title2 = tabData.getValueAt(selrow, 1).toString();

        }
        if (tabData.getValueAt(selrow, 2) != null) {
            textField3.setText(tabData.getValueAt(selrow, 2).toString());

            title3 = tabData.getValueAt(selrow, 2).toString();

        }
        if (tabData.getValueAt(selrow, 3) != null) {
            textField4.setText(tabData.getValueAt(selrow, 3).toString());

            title4 = tabData.getValueAt(selrow, 3).toString();

        }
        if (tabData.getValueAt(selrow, 4) != null) {
            textField5.setText(tabData.getValueAt(selrow, 4).toString());

            title5 = tabData.getValueAt(selrow, 4).toString();

        }
        if (tabData.getValueAt(selrow, 5) != null) {
            textField6.setText(tabData.getValueAt(selrow, 5).toString());

            title6 = tabData.getValueAt(selrow, 5).toString();

        }
        if (tabData.getValueAt(selrow, 6) != null) {
            textField7.setText(tabData.getValueAt(selrow, 6).toString());

            title7 = tabData.getValueAt(selrow, 6).toString();

        }
        if (tabData.getValueAt(selrow, 7) != null) {
            textField8.setText(tabData.getValueAt(selrow, 7).toString());

            title8 = tabData.getValueAt(selrow, 7).toString();

        }
        if (tabData.getValueAt(selrow, 8) != null) {
            textField9.setText(tabData.getValueAt(selrow, 8).toString());

            title9 = tabData.getValueAt(selrow, 8).toString();

        }
        if (tabData.getValueAt(selrow, 9) != null) {
            textField10.setText(tabData.getValueAt(selrow, 9).toString());

            title10 = tabData.getValueAt(selrow, 9).toString();

        }
        if (tabData.getValueAt(selrow, 10) != null) {
            textField11.setText(tabData.getValueAt(selrow, 10).toString());

            title11 = tabData.getValueAt(selrow, 10).toString();

        }
        if (tabData.getValueAt(selrow, 11) != null) {
            textField12.setText(tabData.getValueAt(selrow, 11).toString());

            title12 = tabData.getValueAt(selrow, 11).toString();

        }
        if (tabData.getValueAt(selrow, 12) != null) {
            textField13.setText(tabData.getValueAt(selrow, 12).toString());

            title13 = tabData.getValueAt(selrow, 12).toString();

        }
        if (tabData.getValueAt(selrow, 13) != null) {
            textField14.setText(tabData.getValueAt(selrow, 13).toString());

            title14 = tabData.getValueAt(selrow, 13).toString();

        }

        MulInssql = "INSERT INTO templ (EMPNO,FIRSTNME,MIDINIT,LASTNAME,WORKDEPT,PHONENO, HIREDATE,JOB,EDLEVEL,SEX,BIRTHDATE,SALARY,BONUS,COMM) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        TEMPL templ = new TEMPL(title1, title2, title3, title4, title5, title6, java.sql.Date.valueOf(title7), title8, Integer.valueOf(title9), title10, java.sql.Date.valueOf(title11), title12, title13, title14);
        multempl.add(templ);

    }

}