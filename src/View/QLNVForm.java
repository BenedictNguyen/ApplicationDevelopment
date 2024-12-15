package View;

import DAO.NhanVien_DAO;
import DAO.TaiKhoan_DAO;
import Entity.NhanVien;
import Entity.TaiKhoan;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DatePickerSettings.DateArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class QLNVForm extends javax.swing.JPanel {

    private final NhanVien_DAO nv_dao;
    private DefaultTableModel modelTable;
    private final TaiKhoan_DAO tk_dao;

    /**
     * Creates new form QLNVForm
     */
    public QLNVForm() {
        initComponents();
        try {
            ConnectDB.ConnectDB.getInstance().connect();
            System.out.println("Connected!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        nv_dao = new NhanVien_DAO();
        tk_dao = new TaiKhoan_DAO();
        docDuLieuDatabaseVaoTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        gioiTinhTxt = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sdtNhanVienTxt = new javax.swing.JTextField();
        tenNhanVienTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        maNhanVienTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chucVuTxt = new javax.swing.JComboBox<>();
        DatePickerSettings datePickerSettings = new DatePickerSettings();
        datePickerSettings.setFontValidDate(new Font("Segoe UI", Font.PLAIN, 20));
        datePickerSettings.setFontInvalidDate(new Font("Segoe UI", Font.PLAIN, 20));
        datePickerSettings.setFontCalendarDateLabels(new Font("Segoe UI", Font.PLAIN, 20)); // Fo
        datePickerSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
        datePickerSettings.setColor(DateArea.DatePickerTextDisabled, Color.BLACK);
        ngayVaoLamTxt = new com.github.lgooddatepicker.components.DatePicker(datePickerSettings);
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DatePickerSettings datePickerSettings2 = new DatePickerSettings();
        datePickerSettings2.setFontValidDate(new Font("Segoe UI", Font.PLAIN, 20));
        datePickerSettings2.setFontInvalidDate(new Font("Segoe UI", Font.PLAIN, 20));
        datePickerSettings2.setFontCalendarDateLabels(new Font("Segoe UI", Font.PLAIN, 20)); // Fo
        datePickerSettings2.setFormatForDatesCommonEra("dd/MM/yyyy");
        ngaySinhTxt = new com.github.lgooddatepicker.components.DatePicker(datePickerSettings2);
        emailTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tinhTrangTxt = new javax.swing.JComboBox<>();
        scrollPaneWin111 = new Utils.scroll.win11.ScrollPaneWin11();
        String[] colHeader = {"Mã nhân viên", "Tên nhân viên", "Chức vụ", "Giới tính", "Số điện thoại", "Email","Ngày sinh","Ngày vào làm","Tình trạng"};
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
        jTable2 = new javax.swing.JTable(modelTable);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/incorporation.png"))); // NOI18N
        jButton2.setText("Thêm nhân viên");
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/upgrade.png"))); // NOI18N
        jButton1.setText("Cập nhật");
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        jButton3.setText("Làm mới");
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loupe.png"))); // NOI18N
        jButton4.setText("Tìm");
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        jLabel5.setText("Giới tính");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        gioiTinhTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        gioiTinhTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jLabel3.setText("Chức vụ");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jLabel1.setText("Mã nhân viên");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        sdtNhanVienTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        sdtNhanVienTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtNhanVienTxtActionPerformed(evt);
            }
        });

        tenNhanVienTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tenNhanVienTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenNhanVienTxtActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anonymous_2.png"))); // NOI18N
        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setOpaque(true);

        jLabel6.setText("Ngày vào làm");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        maNhanVienTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        maNhanVienTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        maNhanVienTxt.setEnabled(false);
        maNhanVienTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maNhanVienTxtActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên nhân viên");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jLabel4.setText("Số điện thoại");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        chucVuTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));
        chucVuTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        ngayVaoLamTxt.setEnabled(false);

        jLabel8.setText("Email");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jLabel9.setText("Ngày sinh");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        ngaySinhTxt.setEnabled(false);

        emailTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        emailTxt.setMaximumSize(new java.awt.Dimension(64, 33));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setText("Tình trạng");

        tinhTrangTxt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tinhTrangTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm", "Đã nghỉ" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tenNhanVienTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(maNhanVienTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(chucVuTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sdtNhanVienTxt)
                    .addComponent(gioiTinhTxt, 0, 200, Short.MAX_VALUE)
                    .addComponent(ngayVaoLamTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ngaySinhTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhTrangTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(sdtNhanVienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maNhanVienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(tenNhanVienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gioiTinhTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(chucVuTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(ngaySinhTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(ngayVaoLamTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tinhTrangTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        ngayVaoLamTxt.setDate(LocalDate.now());
        ngaySinhTxt.setDate(LocalDate.now());

        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        scrollPaneWin111.setViewportView(jTable2);
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
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
        jTable2.setRowHeight(jTable2.getRowHeight() + 10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        maNhanVienTxt.setEnabled(false);
        ngayVaoLamTxt.setEnabled(false);
        ngaySinhTxt.setEnabled(false);
        int row = jTable2.getSelectedRow();
        if (row >= 0) {
            maNhanVienTxt.setText((String) modelTable.getValueAt(row, 0));
            tenNhanVienTxt.setText((String) modelTable.getValueAt(row, 1));
            chucVuTxt.setSelectedItem((String) modelTable.getValueAt(row, 2));
            gioiTinhTxt.setSelectedItem((String) modelTable.getValueAt(row, 3));
            sdtNhanVienTxt.setText((String) modelTable.getValueAt(row, 4));
            emailTxt.setText((String) modelTable.getValueAt(row, 5));
            ngaySinhTxt.setDate(LocalDate.parse((CharSequence) modelTable.getValueAt(row, 6)));
            ngayVaoLamTxt.setDate(LocalDate.parse((CharSequence) modelTable.getValueAt(row, 7)));
            tinhTrangTxt.setSelectedItem((String) modelTable.getValueAt(row, 8));
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void maNhanVienTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maNhanVienTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maNhanVienTxtActionPerformed

    private void tenNhanVienTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenNhanVienTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenNhanVienTxtActionPerformed

    private void sdtNhanVienTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtNhanVienTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtNhanVienTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int row = jTable2.getSelectedRow();
       if (row >= 0) {
        String tenNV = tenNhanVienTxt.getText();
        String chucVu = chucVuTxt.getSelectedItem().toString();
        String gioiTinh = gioiTinhTxt.getSelectedItem().toString();
        String sdt = sdtNhanVienTxt.getText();
        String email = emailTxt.getText().trim();
        String tinhTrang = tinhTrangTxt.getSelectedItem().toString();
        NhanVien nv = new NhanVien(maNhanVienTxt.getText(), tenNV, chucVu, gioiTinh, sdt, email, ngaySinhTxt.getDate(), ngayVaoLamTxt.getDate(), tinhTrang);
        if(nv_dao.update(nv)) {
            JOptionPane.showMessageDialog(null,"Cập nhật thành công");
            modelTable.setRowCount(0);
            docDuLieuDatabaseVaoTable();
        }
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ngaySinhTxt.setEnabled(true);
        tenNhanVienTxt.setText("");
        chucVuTxt.setSelectedIndex(0);
        emailTxt.setText("");
        sdtNhanVienTxt.setText("");
        gioiTinhTxt.setSelectedIndex(0);
        ngaySinhTxt.setDate(LocalDate.now());
        ngayVaoLamTxt.setDate(LocalDate.now());
        tinhTrangTxt.setSelectedIndex(0);
        maNhanVienTxt.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String maNV = generateMaNhanVien(LocalDate.now());
        String tenNV = tenNhanVienTxt.getText();
        String chucVu = chucVuTxt.getSelectedItem().toString();
        String gioiTinh = gioiTinhTxt.getSelectedItem().toString();
        String sdt = sdtNhanVienTxt.getText();
        String email = emailTxt.getText().trim();
        LocalDate ngaySinh = ngaySinhTxt.getDate();
        LocalDate ngayVaoLam = ngayVaoLamTxt.getDate();
        String tinhTrang = tinhTrangTxt.getSelectedItem().toString();
        NhanVien nv = new NhanVien(maNV, tenNV, chucVu, gioiTinh, sdt, email, ngaySinh, ngayVaoLam, tinhTrang);
        if(nv_dao.insert(nv)) {
            JOptionPane.showMessageDialog(null,"Thêm nhân viên thành công");
            tk_dao.insert(new TaiKhoan(new NhanVien(maNV),"test"));
            modelTable.setRowCount(0);
            docDuLieuDatabaseVaoTable();
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void docDuLieuDatabaseVaoTable() {
        List<NhanVien> list = nv_dao.getAllTableNhanVien();
        for (NhanVien nv : list) {
            modelTable.addRow(new Object[]{nv.getMaNV(), nv.getTenNV(), nv.getChucVu(), nv.getGioiTinh(), nv.getSdt(), nv.getEmail(), String.valueOf(nv.getNgaySinh()), String.valueOf(nv.getNgayVaoLam()),nv.getTinhTrang()});
        }
    }

    public String generateMaNhanVien(LocalDate date) {
        int day = date.getDayOfMonth(); // Lấy ngày
        int month = date.getMonthValue(); // Lấy tháng
        int year = date.getYear() % 100; // Lấy hai chữ số cuối của năm
        int tt = kiemTraTT(day, month, year);
        // Tạo mã phiếu theo định dạng PXXYYZZAA
        return String.format("NV%02d%02d%02d%02d", ngaySinhTxt.getDate().getYear(), month, year, tt);
    }

    public int kiemTraTT(int day, int month, int year) {
        int tt = 1;
        List<NhanVien> list = nv_dao.getAllTableNhanVien();
        for (NhanVien nv : list) {
            if (nv.getMaNV().substring(4, 6).equals(String.valueOf(month) + String.valueOf(year))) {
                tt += 1;
            }
        }
        return tt;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> chucVuTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JComboBox<String> gioiTinhTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField maNhanVienTxt;
    private com.github.lgooddatepicker.components.DatePicker ngaySinhTxt;
    private com.github.lgooddatepicker.components.DatePicker ngayVaoLamTxt;
    private Utils.scroll.win11.ScrollPaneWin11 scrollPaneWin111;
    private javax.swing.JTextField sdtNhanVienTxt;
    private javax.swing.JTextField tenNhanVienTxt;
    private javax.swing.JComboBox<String> tinhTrangTxt;
    // End of variables declaration//GEN-END:variables
}
