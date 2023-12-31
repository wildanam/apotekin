/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lima.components;

import com.lima.models.ModelLogin;
import com.lima.swing.Button;
import com.lima.swing.MyTextField;
import com.lima.swing.PasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Wildan
 */
public class PanelLogin extends javax.swing.JPanel {

    private ModelLogin dataLogin;
    /**
     * Creates new form PanelLogin
     */
    public PanelLogin(ActionListener eventLogin) {
        initComponents();
        initLogin(eventLogin);
    }
    
    private void initLogin(ActionListener eventLogin) {
        this.setLayout(new MigLayout("wrap", "push[]push", "200[]50[]10[]50[]"));
        JLabel label = new JLabel("Selamat Datang");
        label.setFont(new Font("sanserif", 1, 30));
        label.setForeground(new Color(0, 0, 0));
        this.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/lima/assets/user.png")));
        txtUser.setHint("Username");
        this.add(txtUser, "w 40%");
        PasswordField txtPassword = new PasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/com/lima/assets/pass.png")));
        txtPassword.setHint("Password");
        this.add(txtPassword, "w 40%");
        Button cmd = new Button();
        cmd.setBackground(new Color(102, 153, 255));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventLogin);
        cmd.setText("Masuk");
        this.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userName = txtUser.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());
                dataLogin = new ModelLogin(userName, password);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public ModelLogin getDataLogin() {
        return dataLogin;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
