/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DAO.ChiTietHoaDon_DAO;
import DAO.HoaDon_DAO;
import DAO.MonAn_DAO;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLHDForm extends javax.swing.JPanel {

    private final HoaDon_DAO hoaDon_dao;
    private DefaultTableModel modelTable;
    private final ChiTietHoaDon_DAO chiTiet_dao;
    private DefaultTableModel modelTable2;
    private final MonAn_DAO monAn_dao;

    /**
     * Creates new form QLHDForm
     */
    public QLHDForm() {
        initComponents();
        try {
            ConnectDB.ConnectDB.getInstance().connect();
            System.out.println("Connected!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hoaDon_dao = new HoaDon_DAO();
        chiTiet_dao = new ChiTietHoaDon_DAO();
        monAn_dao = new MonAn_DAO();
        docDuLieuDatabaseVaoTableHoaDon();

    }

    private void docDuLieuDatabaseVaoTableHoaDon() {
        List<HoaDon> list = hoaDon_dao.getAllTableHoaDon();
        for (HoaDon hd : list) {
            if (hd.getTrangThai().equals("Đã thanh toán")) {
                modelTable.addRow(new Object[]{hd.getMaHD(), hd.getNgayLap(), hd.getPhuongThuc(), hd.getMaNV().getMaNV(), hd.getMaKH().getMaKH(), hd.getMaBan().getMaBan(), hd.getThanhTien()});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        scrollPaneWin112 = new Utils.scroll.win11.ScrollPaneWin11();
        String[] colHeader2 = {"Tên món","Số lượng","Đơn giá","Tổng tiền"};
        modelTable2 = new DefaultTableModel(colHeader2, 0) {
            /**
            *
            */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable2 = new javax.swing.JTable(modelTable2);
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        scrollPaneWin111 = new Utils.scroll.win11.ScrollPaneWin11();
        DecimalFormat df = new DecimalFormat("#");
        df.setGroupingUsed(false);
        String[] colHeader = {"Mã hóa đơn","Ngày lập","Phương thức thanh toán","Mã nhân viên","Mã khách hàng","Mã bàn","Thành tiền"};
        modelTable = new DefaultTableModel(colHeader, 0) {
            /**
            *
            */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1 = new javax.swing.JTable(modelTable);
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jDialog1.setModal(true);

        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        scrollPaneWin112.setViewportView(jTable2);
        scrollPaneWin112.setColumnHeader(new JViewport() {
            /**
            *
            */
            private static final long serialVersionUID = 1L;

            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.height = 32;
                return d;
            }
        });
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
        jTable2.setRowHeight(jTable1.getRowHeight() + 10);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneWin112, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jTable1.setMaximumSize(new java.awt.Dimension(200, 0));
        scrollPaneWin111.setViewportView(jTable1);
        scrollPaneWin111.setColumnHeader(new JViewport() {
            /**
            *
            */
            private static final long serialVersionUID = 1L;

            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.height = 32;
                return d;
            }
        });
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
        jTable1.setRowHeight(jTable1.getRowHeight() + 10);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof Number) {
                    value = df.format(value);
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        jTable1.getColumnModel().getColumn(6).setCellRenderer(renderer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/seen.png"))); // NOI18N
        jButton4.setText("Xem hóa đơn");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loupe.png"))); // NOI18N
        jButton5.setText("Tìm kiếm");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/printer.png"))); // NOI18N
        jButton6.setText("In hóa đơn");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            modelTable2.setRowCount(0);
            docDuLieuDatabaseVaoTableChiTiet();
            jDialog1.setSize(565, 400);
            jDialog1.setLocationRelativeTo(null);
            jDialog1.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jDialog1.dispose();
        modelTable2.setRowCount(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void docDuLieuDatabaseVaoTableChiTiet() {
        int row = jTable1.getSelectedRow();
        List<ChiTietHoaDon> list = chiTiet_dao.getAllTableChiTietHoaDon();
        for (ChiTietHoaDon cthd : list) {
            if (cthd.getMaHD().getMaHD().equals(jTable1.getValueAt(row, 0))) {
                modelTable2.addRow(new Object[]{monAn_dao.searchTenMonAnTheoMa(cthd.getMaMA().getMaMA()), cthd.getSoLuong(), monAn_dao.searchDonGiaMonAnTheoMa(cthd.getMaMA().getMaMA()), cthd.getTongTien()});
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private Utils.scroll.win11.ScrollPaneWin11 scrollPaneWin111;
    private Utils.scroll.win11.ScrollPaneWin11 scrollPaneWin112;
    // End of variables declaration//GEN-END:variables
}
