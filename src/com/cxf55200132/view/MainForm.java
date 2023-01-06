/*
 * Created by JFormDesigner on Fri Dec 23 17:06:51 CST 2022
 */

package com.cxf55200132.view;

import java.awt.event.*;
import com.cxf55200132.DAO.Dao.ACTDAO;
import com.cxf55200132.DAO.Domain.ACT;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Tlaloc
 */
public class MainForm extends JFrame {
    public MainForm() throws SQLException {
        initComponents();
        InitTable();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void btn_add(ActionEvent e) {
        // TODO add your code here
        new Add();
    }

    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        btn_add = new JButton();
        btn_delete = new JButton();
        btn_update = new JButton();
        btn_query = new JButton();
        scrollPane1 = new JScrollPane();
        showpane = new JTable();

        //======== this ========
        setTitle("DB2_55200132cxf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- btn_add ----
        btn_add.setText("\u589e\u52a0");
        btn_add.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        btn_add.addActionListener(e -> btn_add(e));
        contentPane.add(btn_add);
        btn_add.setBounds(20, 35, 105, 50);

        //---- btn_delete ----
        btn_delete.setText("\u5220\u9664");
        btn_delete.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        contentPane.add(btn_delete);
        btn_delete.setBounds(160, 35, 105, 50);

        //---- btn_update ----
        btn_update.setText("\u4fee\u6539");
        btn_update.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        contentPane.add(btn_update);
        btn_update.setBounds(300, 35, 105, 50);

        //---- btn_query ----
        btn_query.setText("\u67e5\u8be2");
        btn_query.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        contentPane.add(btn_query);
        btn_query.setBounds(440, 35, 105, 50);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(showpane);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 100, 520, 185);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton btn_add;
    private JButton btn_delete;
    private JButton btn_update;
    private JButton btn_query;
    private JScrollPane scrollPane1;
    private JTable showpane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    DefaultTableModel dtm;


    public void InitTable() throws SQLException {
        ACTDAO actdao = new ACTDAO();
        List<ACT> list = actdao.QueryMultiply("SELECT * FROM act WHERE ACTNO >= ?", ACT.class,20);
        Object[][] data = new Object[list.size()][3];
        for (int i = 0; i < data.length ; i++) {
            data[i][0] = list.get(i).getACTNO();
            data[i][1] = list.get(i).getACTKWD();
            data[i][2] = list.get(i).getACTDESC();

        }
        String[] columeNames = {"ACTNO","ACTKWD","ACTDESC"};

        dtm = new DefaultTableModel(data,columeNames);
        showpane.setModel(dtm);
    }

    public static void main(String[] args) throws SQLException {
        new MainForm();
    }
}
