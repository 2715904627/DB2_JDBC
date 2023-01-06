package com.cxf55200132.ui;

import com.cxf55200132.DAO.Dao.ACTDAO;
import com.cxf55200132.DAO.Domain.ACT;
import com.cxf55200132.view.MainForm;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class MainTab {
    private ACTDAO actdao = new ACTDAO();
    String[] columnNames = {"ACTNO","ACTKWD","ACTDESC"};





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


    public MainTab() throws SQLException {
        InitView();



        /*

        Need to Modify
        */

        btn_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<ACT> list = actdao.QueryMultiply("SELECT * FROM act WHERE ACTNO >= ?", ACT.class,10);

                    Object[][] data = new Object[list.size()][3];
                    for (int i = 0; i < data.length ; i++) {
                        data[i][0] = list.get(i).getACTNO();
                        data[i][1] = list.get(i).getACTKWD();
                        data[i][2] = list.get(i).getACTDESC();
                        tabData.setModel(new DefaultTableModel(data, columnNames));

                    }


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }

        });


//        tabData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                int[] selrow = tabData.getSelectedRows();
//                int i = selrow.length;
//                while(i>0){
//                   i--;
//                   setACTvalues(selrow[i]);
//                }
//            }
//        });
        tabData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selrow = tabData.getSelectedRow();
                if (selrow > -1) {
                    setACTvalues(selrow);
                }
            }
        });
        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actno = textField1.getText();
                String actkwd = textField2.getText();
                String actdesc = textField3.getText();
                ACT act = new ACT(Integer.valueOf(actno),actkwd,actdesc);
//                System.out.println(act);
//                ACTDAO actDAO = new ACTDAO();
//        System.out.println(act.getACTNO());
                try {
                    int rows = actdao.Update("INSERT INTO act (ACTNO,ACTKWD,ACTDESC) VALUES(?,?,?)",act.getACTNO(),act.getACTKWD(),act.getACTDESC());
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
        btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actno = textField1.getText();
                String actkwd = textField2.getText();
                String actdesc = textField3.getText();
                ACT act = new ACT(Integer.valueOf(actno),actkwd,actdesc);
//                System.out.println(act);
//                ACTDAO actDAO = new ACTDAO();
//        System.out.println(act.getACTNO());
                try {
                    int rows = actdao.Update("update act set actkwd = ? where actno = ?",act.getACTKWD(),act.getACTNO());
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
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete from act where actno = 111
                String actno = textField1.getText();
                String actkwd = textField2.getText();
                String actdesc = textField3.getText();
                ACT act = new ACT(Integer.valueOf(actno),actkwd,actdesc);
//                System.out.println(act);
//                ACTDAO actDAO = new ACTDAO();
//               System.out.println(act.getACTNO());
                try {
                    int rows = actdao.Update("delete from act where actno = ?",act.getACTNO());
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


    public static void main(String[] args) throws SQLException {
        MainTab mainTab = new MainTab();
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


    private void setACTvalues(int selrow) {
        if (tabData.getValueAt(selrow, 0) != null) {
            textField1.setText(tabData.getValueAt(selrow,0).toString());

        }
        if (tabData.getValueAt(selrow, 1) != null) {
            textField2.setText(tabData.getValueAt(selrow,1).toString());

        }
        if (tabData.getValueAt(selrow, 2) != null) {
            textField3.setText(tabData.getValueAt(selrow,2).toString());

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

//        }
    }
}
