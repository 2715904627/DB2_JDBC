/*
 * Created by JFormDesigner on Fri Dec 23 19:30:30 CST 2022
 */

package com.cxf55200132.view;

import com.cxf55200132.DAO.Dao.ACTDAO;
import com.cxf55200132.DAO.Domain.ACT;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author Tlaloc
 */
public class Add extends JFrame {
    public Add() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void _add(ActionEvent e) throws SQLException {
        // TODO add your code here
        //get the value in textfield
        String actno = textField_actno.getText();
        String actkwd = textField_actkwd.getText();
        String actdesc = textField_actdesc.getText();
        ACT act = new ACT(Integer.valueOf(actno),actkwd,actdesc);
        System.out.println(act);
        ACTDAO actDAO = new ACTDAO();
//        System.out.println(act.getACTNO());
        int rows = actDAO.Update("INSERT INTO act (ACTNO,ACTKWD,ACTDESC) VALUES(?,?,?)",act.getACTNO(),act.getACTKWD(),act.getACTDESC());
//        int rows = actDAO.Update("INSERT INTO act (ACTNO,ACTKWD,ACTDESC) VALUES(121,'DOC','DOCUMENT')");

        if(rows>0){
            JOptionPane.showMessageDialog(null,"Greetings");
        }
        else {
            JOptionPane.showMessageDialog(null,"Sorry");

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label_actkwd = new JLabel();
        label_actdest = new JLabel();
        label_actno = new JLabel();
        textField_actno = new JTextField();
        textField_actkwd = new JTextField();
        textField_actdesc = new JTextField();
        button_add = new JButton();
        button_refresh = new JButton();

        //======== this ========
        setTitle("Add");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label_actkwd ----
        label_actkwd.setText("ACTKWD");
        label_actkwd.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        contentPane.add(label_actkwd);
        label_actkwd.setBounds(33, 110, 75, 45);

        //---- label_actdest ----
        label_actdest.setText("ACTDESC");
        label_actdest.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        contentPane.add(label_actdest);
        label_actdest.setBounds(33, 195, 75, 45);

        //---- label_actno ----
        label_actno.setText("ACTNO");
        label_actno.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        contentPane.add(label_actno);
        label_actno.setBounds(33, 25, 75, 45);
        contentPane.add(textField_actno);
        textField_actno.setBounds(125, 25, 270, 45);
        contentPane.add(textField_actkwd);
        textField_actkwd.setBounds(125, 110, 270, 45);
        contentPane.add(textField_actdesc);
        textField_actdesc.setBounds(125, 195, 270, 45);

        //---- button_add ----
        button_add.setText("Add");
        button_add.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        button_add.addActionListener(e -> {
            try {
                _add(e);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        contentPane.add(button_add);
        button_add.setBounds(40, 260, 130, 50);

        //---- button_refresh ----
        button_refresh.setText("Refresh");
        button_refresh.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        contentPane.add(button_refresh);
        button_refresh.setBounds(220, 260, 130, 50);

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
    private JLabel label_actkwd;
    private JLabel label_actdest;
    private JLabel label_actno;
    private JTextField textField_actno;
    private JTextField textField_actkwd;
    private JTextField textField_actdesc;
    private JButton button_add;
    private JButton button_refresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {
        new Add();
    }
}
