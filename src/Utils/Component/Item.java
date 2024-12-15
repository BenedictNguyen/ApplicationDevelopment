/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Utils.Component;

import Entity.Ban;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author ADMIN
 */
public class Item extends javax.swing.JPanel {

    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    
    
    public Item() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private Ban data;

    public Ban getData() {
        return data;
    }
    
    public void setData(Ban data) {
        this.data = data;
        ban.setText("Bàn " + data.getMaBan().substring(1));
        switch (data.getTrangThai()) {
            case "Trống" -> banImg.setBackground(new Color(255,204,204));
            case "Đã đặt trước" -> banImg.setBackground(new Color(255,51,51));
            case "Đang sử dụng" -> banImg.setBackground(new Color(102,255,102));
            case "Bảo trì" -> banImg.setBackground(new Color(153,153,153));
            default -> {
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242,242,242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20,20);
        if(selected) {
            g2.setColor(new Color(94,156,255));
            g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        }
        g2.dispose();
        super.paint(g);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ban = new javax.swing.JLabel();
        banImg = new Utils.Swing.PictureBox();

        ban.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ban.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ban.setText("Bàn");

        banImg.setBackground(new java.awt.Color(245, 245, 245));
        banImg.setImage(new javax.swing.ImageIcon(getClass().getResource("/Image/dining-table (1).png"))); // NOI18N
        banImg.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(banImg, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(banImg, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ban)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ban;
    private Utils.Swing.PictureBox banImg;
    // End of variables declaration//GEN-END:variables
}
